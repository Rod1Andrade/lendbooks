package com.github.rod1andrade.lendbookbackend.features.auth.external.controller;

 import com.github.rod1andrade.lendbookbackend.features.auth.core.exceptions.ImpossibleSendMailException;
import com.github.rod1andrade.lendbookbackend.features.auth.core.factories.*;
import com.github.rod1andrade.lendbookbackend.features.auth.core.ports.UserInputData;
import com.github.rod1andrade.lendbookbackend.features.auth.core.usecases.interfaces.IActiveRegisteredUserByTokenUsecase;
import com.github.rod1andrade.lendbookbackend.features.auth.core.usecases.interfaces.IDispatchConfirmMailUsecase;
import com.github.rod1andrade.lendbookbackend.features.auth.core.usecases.interfaces.IRegisterUserUsecase;
import com.github.rod1andrade.lendbookbackend.features.auth.core.usecases.interfaces.IValidateUserUsecase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping(value = "/auth")
@RequiredArgsConstructor
@Slf4j
public class AuthController {

    private final Environment env;

    private final PasswordEncoder passwordEncoder;

    private final IValidateUserUsecaseFactory validateUserUsecaseFactory;
    private final IRegisterUserUsecaseFactory registerUserUsecaseFactory;
    private final IDispatchConfirmMailUsecaseFactory dispatchConfirmMailUsecaseFactory;
    private final IActiveRegisterdUserByTokenFactory activeRegisterdUserByTokenFactory;
    private final IDeleteUserUsecaseFactory deleteUserUsecaseFactory;

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
            e.printStackTrace();
            deleteUserUsecaseFactory.create().apply(userInputData);
            throw e;
        } catch (Exception e) {
            e.printStackTrace();
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

}
