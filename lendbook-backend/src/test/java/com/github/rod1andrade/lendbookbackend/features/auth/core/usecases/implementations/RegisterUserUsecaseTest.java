package com.github.rod1andrade.lendbookbackend.features.auth.core.usecases.implementations;

import com.github.rod1andrade.lendbookbackend.features.auth.core.exceptions.RegisterUserExcepion;
import com.github.rod1andrade.lendbookbackend.features.auth.core.ports.UserInputData;
import com.github.rod1andrade.lendbookbackend.features.auth.core.repositories.ICommandUserRepository;
import com.github.rod1andrade.lendbookbackend.features.auth.core.usecases.interfaces.IRegisterUserUsecase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class RegisterUserUsecaseTest {

    UserInputData userInputData = UserInputData.builder().password("testing-pass").build();

    ICommandUserRepository commandUserRepository = Mockito.mock(ICommandUserRepository.class);
    IRegisterUserUsecase userUsecase = new RegisterUserUsecase(commandUserRepository);

    @Test
    void shouldRegisterAUser() {
        userUsecase.apply(
                userInputData,
                (pass) -> pass.toUpperCase() + "ENCODEDTEST"
        );

        Mockito.verify(commandUserRepository, Mockito.atLeastOnce()).save(Mockito.any());
    }

    @Test
    void shouldThrowARegisterUserExcepionWhenItsNotPossibleRegisterAUser() {
        Mockito.doThrow(RegisterUserExcepion.class).when(commandUserRepository).save(Mockito.any());
        Assertions.assertThrows(
                RegisterUserExcepion.class,
                () -> userUsecase.apply(
                        userInputData,
                        (pass) -> pass.toUpperCase() + "ENCODEDTEST"
                )
        );
    }

}