package com.github.rod1andrade.lendbookbackend.filters;

import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.github.rod1andrade.lendbookbackend.features.auth.core.exceptions.UserNotFoundException;
import com.github.rod1andrade.lendbookbackend.features.auth.external.security.LendBooksJWT;
import com.github.rod1andrade.lendbookbackend.services.UserDetailServiceImpl;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@Slf4j
@RequiredArgsConstructor
public class JWTFilter extends OncePerRequestFilter {

    public static final String TOKEN_PREFIX = "Bearer ";

    private final LendBooksJWT lendBooksJWT;
    private final UserDetailServiceImpl userDetailService;

    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            @NonNull HttpServletResponse response,
            @NonNull FilterChain filterChain
    ) throws ServletException, IOException {
        final String token = request.getHeader("Authorization");
        log.info("token: {}", token);

        if (token != null && token.startsWith(TOKEN_PREFIX)) {
            String plainToken = token.substring(TOKEN_PREFIX.length());
            log.info("plain token: {}", plainToken);

            try {
                DecodedJWT decodedJWT = lendBooksJWT.verify(plainToken);
                String uuid = lendBooksJWT.getClaim(decodedJWT, "uuid").asString();
                log.info("Decoded: {}", uuid);

                UserDetails userDetails = userDetailService.loadUserByUUID(uuid);

                var userToken = new UsernamePasswordAuthenticationToken(
                        userDetails,
                        null,
                        userDetails.getAuthorities()
                );
                userToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(userToken);
            } catch (JWTVerificationException | UserNotFoundException e) {
                log.info(e.getMessage());
                filterChain.doFilter(request, response);
            }
        }

        filterChain.doFilter(request, response);
    }
}
