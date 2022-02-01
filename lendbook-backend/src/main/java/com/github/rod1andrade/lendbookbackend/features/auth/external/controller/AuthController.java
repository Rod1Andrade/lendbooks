package com.github.rod1andrade.lendbookbackend.features.auth.external.controller;

import com.github.rod1andrade.lendbookbackend.features.auth.core.usecases.interfaces.IRegisterUserUsecase;
import com.github.rod1andrade.lendbookbackend.features.auth.external.dtos.UserModelDTO;
import com.github.rod1andrade.lendbookbackend.features.auth.external.event.OnSuccessRegistrationEvent;
import com.github.rod1andrade.lendbookbackend.features.auth.external.factories.RegisterUserUsecaseFactory;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(value = "/auth")
@RequiredArgsConstructor
@Slf4j
public class AuthController {

    private final PasswordEncoder passwordEncoder;
    private final RegisterUserUsecaseFactory registerUserUsecaseFactory;
    private final ApplicationEventPublisher applicationEventPublisher;
    private final Environment env;

    @PostMapping(value = "/signUp")
    public ResponseEntity<Void> registerUser(@RequestBody UserModelDTO userModelDTO) {
        IRegisterUserUsecase userUsecase = registerUserUsecaseFactory.create();
        var user = UserModelDTO.castUserMOdelDTOToUser(userModelDTO, passwordEncoder);

        userUsecase.apply(user);

        applicationEventPublisher.publishEvent(
                new OnSuccessRegistrationEvent(
                        user,
                        env.getProperty("app.host")
                )
        );

        return ResponseEntity.ok().build();
    }

    @GetMapping(value = "/confirmAccount")
    public ResponseEntity<Void> confirmAccount(@RequestParam String token) {
        log.info("TODO: Criar rota para mudar o status para ativo do token: {}", token);
        return ResponseEntity.ok().build();
    }

}
