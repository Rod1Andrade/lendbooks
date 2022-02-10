package com.github.rod1andrade.lendbookbackend.features.auth.core.usecases.implementations;

import com.github.rod1andrade.lendbookbackend.features.auth.core.entities.User;
import com.github.rod1andrade.lendbookbackend.features.auth.core.exceptions.EmailAlreadyExistsException;
import com.github.rod1andrade.lendbookbackend.features.auth.core.exceptions.InvalidUserExcepetion;
import com.github.rod1andrade.lendbookbackend.features.auth.core.ports.AbstractUserInputData;
import com.github.rod1andrade.lendbookbackend.features.auth.core.ports.UserInputData;
import com.github.rod1andrade.lendbookbackend.features.auth.core.repositories.IQueryUserRepository;
import com.github.rod1andrade.lendbookbackend.features.auth.core.usecases.interfaces.IValidateUserUsecase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class ValidateUserUsecaseTest {
    private final IQueryUserRepository  queryUserRepository = Mockito.mock(IQueryUserRepository.class);
    private final IValidateUserUsecase usecase = new ValidateUserUsecase(queryUserRepository);

    @Test
    public void shouldThrowAInvalidUserExceptionWhenSomePropertyIsNull() {
        AbstractUserInputData mockUserInputData = new UserInputData();
        Assertions.assertThrows(
                InvalidUserExcepetion.class,
                () -> usecase.apply(mockUserInputData),
                "Is necessary: name, lastname, email and password."
        );
    }

    @Test
    public void shouldThrowAEmailAlredyExistsExceptionWhenSomePropertyIsNull() {
        AbstractUserInputData mockUserInputData = UserInputData.builder()
                .name("mock")
                .lastName("mock")
                .password("mock")
                .email("mock@email.com")
                .build();

        Mockito.when(queryUserRepository.findByEmail(Mockito.any())).thenReturn(new User());

        Assertions.assertThrows(
                EmailAlreadyExistsException.class,
                () -> usecase.apply(mockUserInputData),
                "Email alredy exists."
        );
    }

    @Test
    public void shouldDoNothingWhenHasAValidUser() {
        AbstractUserInputData mockUserInputData = UserInputData.builder()
                .name("mock")
                .lastName("mock")
                .password("mock")
                .email("mock@email.com")
                .build();

        usecase.apply(mockUserInputData);
        Mockito.verify(queryUserRepository, Mockito.atLeastOnce()).findByEmail(Mockito.any());
    }
}