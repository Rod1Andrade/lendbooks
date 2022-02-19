package com.github.rod1andrade.lendbookbackend.features.auth.external.controller;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import com.github.rod1andrade.lendbookbackend.features.auth.core.factories.*;
import com.github.rod1andrade.lendbookbackend.features.auth.core.usecases.interfaces.*;
import com.github.rod1andrade.lendbookbackend.features.auth.core.valueobjects.Email;
import com.github.rod1andrade.lendbookbackend.features.auth.core.valueobjects.Password;
import com.github.rod1andrade.lendbookbackend.features.auth.external.dtos.AuthenticateTokenDTO;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.rod1andrade.lendbookbackend.features.auth.core.exceptions.ImpossibleSendMailException;
import com.github.rod1andrade.lendbookbackend.features.auth.core.ports.UserInputData;
import com.github.rod1andrade.lendbookbackend.features.auth.external.security.LendBooksJWT;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping(value = "/auth")
@RequiredArgsConstructor
@Slf4j
public class AuthController {

    private final LendBooksJWT lendBooksJWT;

    private final Environment env;

    private final PasswordEncoder passwordEncoder;

    private final IValidateUserUsecaseFactory validateUserUsecaseFactory;
    private final IRegisterUserUsecaseFactory registerUserUsecaseFactory;
    private final IDispatchConfirmMailUsecaseFactory dispatchConfirmMailUsecaseFactory;
    private final IActiveRegisterdUserByTokenFactory activeRegisterdUserByTokenFactory;
    private final IDeleteUserUsecaseFactory deleteUserUsecaseFactory;

    private final IAuthenticateUserUsecaseFactory authenticateUserUsecaseFactory;

    private final IConfirmMailFactory confirmMailFactory;

    @PostMapping(value = "/signUp")
    public ResponseEntity<Void> registerUser(@RequestBody UserInputData userInputData) {
        log.info("Sign up called");

        // Fabrica os casos de uso
        IValidateUserUsecase validateUserUsecase = validateUserUsecaseFactory.create();
        IRegisterUserUsecase registerUserUsecase = registerUserUsecaseFactory.create();
        IDispatchConfirmMailUsecase dispatchConfirmMailUsecase = dispatchConfirmMailUsecaseFactory.create();

        // Usa os casos de uso
        validateUserUsecase.apply(userInputData);
        registerUserUsecase.apply(userInputData, passwordEncoder::encode);

        try {
            dispatchConfirmMailUsecase.apply(
                    confirmMailFactory.create(
                            registerUserUsecase.getOutputDate().getEmail(),
                            env.getProperty("app.host"),
                            registerUserUsecase.getOutputDate().getToken()
                    )
            );
        } catch (ImpossibleSendMailException e) {
            deleteUserUsecaseFactory.create().apply(userInputData);
            throw e;
        } catch (Exception e) {
            deleteUserUsecaseFactory.create().apply(userInputData);
        }

        return ResponseEntity.ok().build();
    }

    @GetMapping(value = "/confirmAccount")
    public ResponseEntity<Void> confirmAccount(@RequestParam String token) {
        IActiveRegisteredUserByTokenUsecase activeRegisteredUserByTokenUsecase =
                activeRegisterdUserByTokenFactory.create();

        activeRegisteredUserByTokenUsecase.apply(token);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(URI.create(env.getProperty("app.web") + "/confirmAccountSuccess"));

        return new ResponseEntity<>(headers, HttpStatus.MOVED_PERMANENTLY);
    }

    @PostMapping(value = "/signIn")
    public ResponseEntity<AuthenticateTokenDTO> signIn(@RequestBody UserInputData userInputData) {
        IAuthenticateUserUsecase authenticateUserUsecase = authenticateUserUsecaseFactory.create(passwordEncoder::matches);

        log.info("Sign in with: {}", userInputData);

        Email email = new Email(userInputData.getEmail());
        Password password = new Password(userInputData.getPassword());

        var uuid = authenticateUserUsecase.apply(email, password);
        lendBooksJWT.addClaim("uuid", uuid.getValue());

        return ResponseEntity.ok().body(
            new AuthenticateTokenDTO(
                lendBooksJWT.token(),
                lendBooksJWT.refreshToken()
            )
        );
    }

    @GetMapping(value = "/ping")
    private ResponseEntity<String> ping() {

        return ResponseEntity.ok().body("Pong");
    }
}
