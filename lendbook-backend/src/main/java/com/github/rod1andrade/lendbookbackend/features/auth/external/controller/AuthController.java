package com.github.rod1andrade.lendbookbackend.features.auth.external.controller;

import com.github.rod1andrade.lendbookbackend.features.auth.core.factories.IActiveRegisterdUserByTokenFactory;
import com.github.rod1andrade.lendbookbackend.features.auth.core.factories.IRegisterUserUsecaseFactory;
import com.github.rod1andrade.lendbookbackend.features.auth.core.ports.UserInputData;
import com.github.rod1andrade.lendbookbackend.features.auth.core.usecases.interfaces.IActiveRegisteredUserByTokenUsecase;
import com.github.rod1andrade.lendbookbackend.features.auth.core.usecases.interfaces.IRegisterUserUsecase;
import com.github.rod1andrade.lendbookbackend.features.auth.external.event.OnSuccessRegistrationEvent;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.net.URI;

@RestController
@Api(value = "Auth")
@RequestMapping(value = "/auth", name = "Authentication")
@RequiredArgsConstructor
@Slf4j
public class AuthController {

    private final Environment env;

    private final PasswordEncoder passwordEncoder;

    private final IRegisterUserUsecaseFactory registerUserUsecaseFactory;
    private final IActiveRegisterdUserByTokenFactory activeRegisterdUserByTokenFactory;

    private final ApplicationEventPublisher applicationEventPublisher;

    @ApiOperation(
            value = "Adiciona um novo usuário",
            notes = "Quando um usuário é adicionado com sucesso, um e-mail para verificação da conta é enviado."
    )
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Criado com sucesso."),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
    })
    @PostMapping(value = "/signUp")
    public ResponseEntity<Void> registerUser(@RequestBody UserInputData userInputData, HttpServletRequest request) {
        log.info("Sign up called");
        IRegisterUserUsecase registerUserUsecase = registerUserUsecaseFactory.create();
        registerUserUsecase.apply(userInputData, passwordEncoder::encode);

        applicationEventPublisher.publishEvent(
                new OnSuccessRegistrationEvent(
                        registerUserUsecase.getOutputDate(),
                        env.getProperty("app.host")
                )
        );
        return ResponseEntity.created(URI.create(request.getRequestURI())).build();
    }

    @ApiOperation(
            value = "Confirma o token do usuário",
            notes = "Quado o token é válido, o usuário é redirecionado para a aplicação web."
    )
    @ApiResponses(value = {
            @ApiResponse(code = 301, message = "Token válido e usuário redirecionado para a aplicação web."),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
    })
    @GetMapping(value = "/confirmAccount")
    public ResponseEntity<Void> confirmAccount(@RequestParam String token) {
        IActiveRegisteredUserByTokenUsecase activeRegisteredUserByTokenUsecase =
                activeRegisterdUserByTokenFactory.create();

        activeRegisteredUserByTokenUsecase.apply(token);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(URI.create(env.getProperty("app.web") + "/confirmAccountSuccess"));

        return new ResponseEntity<Void>(headers, HttpStatus.MOVED_PERMANENTLY);
    }

}
