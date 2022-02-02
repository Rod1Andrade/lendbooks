package com.github.rod1andrade.lendbookbackend.features.auth.external.controller;

import com.github.rod1andrade.lendbookbackend.features.auth.core.factories.IActiveRegisterdUserByTokenFactory;
import com.github.rod1andrade.lendbookbackend.features.auth.core.factories.IRegisterUserUsecaseFactory;
import com.github.rod1andrade.lendbookbackend.features.auth.core.ports.UserInputData;
import com.github.rod1andrade.lendbookbackend.features.auth.core.usecases.interfaces.IActiveRegisteredUserByTokenUsecase;
import com.github.rod1andrade.lendbookbackend.features.auth.core.usecases.interfaces.IRegisterUserUsecase;
import com.github.rod1andrade.lendbookbackend.features.auth.external.event.OnSuccessRegistrationEvent;
import com.github.rod1andrade.lendbookbackend.features.auth.external.factories.RegisterUserUsecaseFactory;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/auth")
@RequiredArgsConstructor
@Slf4j
public class AuthController {

    private final Environment env;

    private final PasswordEncoder passwordEncoder;

    private final IRegisterUserUsecaseFactory registerUserUsecaseFactory;
    private final IActiveRegisterdUserByTokenFactory activeRegisterdUserByTokenFactory;

    private final ApplicationEventPublisher applicationEventPublisher;

    @PostMapping(value = "/signUp")
    public ResponseEntity<Void> registerUser(@RequestBody UserInputData userInputData) {
        IRegisterUserUsecase registerUserUsecase = registerUserUsecaseFactory.create();
        registerUserUsecase.apply(userInputData, passwordEncoder::encode);

        applicationEventPublisher.publishEvent(
                new OnSuccessRegistrationEvent(
                        registerUserUsecase.getOutputDate(),
                        env.getProperty("app.host")
                )
        );

        return ResponseEntity.ok().build();
    }

    @GetMapping(value = "/confirmAccount")
    public ResponseEntity<Void> confirmAccount(@RequestParam String token) {
        IActiveRegisteredUserByTokenUsecase activeRegisteredUserByTokenUsecase =
                activeRegisterdUserByTokenFactory.create();

        activeRegisteredUserByTokenUsecase.apply(token);

        return ResponseEntity.ok().build();
    }

}
