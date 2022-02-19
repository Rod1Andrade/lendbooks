package com.github.rod1andrade.lendbookbackend.features.auth.external.security;


import java.time.Instant;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

/**
 * 
 * @author rodri
 *
 */
@Component
public class LendBooksJWT {

	@Value("${jwt.secret}")
	private String secret;

	@Value("${jwt.expiration}")
	private int expiration;

	@Value("${jwt.expiration.refresh}")
	private int refreshExpiration;
	
	private Algorithm algorithm;

	private final Map<String, Object> claims = new HashMap<>();

	public String test() {
		return "This is my secret: " + secret;
	}

	public void addClaim(String key, Object value) {
		claims.put(key, value);
	}

	public Algorithm algorithm() {
		if(algorithm == null) {
			algorithm = Algorithm.HMAC256(secret.getBytes());
		}
		return algorithm;
	}

	/**
	 * Default token
	 *
	 * @return String
	 */
	public String token() {
		return JWT.create()
				.withIssuer("token")
				.withPayload(claims)
				.withExpiresAt(Date.from(Instant.now().plusSeconds(expiration)))
				.sign(algorithm());
	}

	/**
	 * Refresh token
	 *
	 * @return String
	 */
	public String refreshToken() {
		return JWT.create()
				.withIssuer("refresh_token")
				.withPayload(claims)
				.withExpiresAt(Date.from(Instant.now().plusSeconds(refreshExpiration)))
				.sign(algorithm());
	}

	public DecodedJWT verify(String token) throws JWTVerificationException {
		JWTVerifier verifier = JWT.require(algorithm()).build();
		return verifier.verify(token);
	}

	public Claim getClaim(DecodedJWT decodedJWT, String claim) {
		return decodedJWT.getClaim(claim);
	}
}
