package com.github.rod1andrade.lendbookbackend.features.auth.core.usecases.implementations;

import com.github.rod1andrade.lendbookbackend.features.auth.core.entities.User;
import com.github.rod1andrade.lendbookbackend.features.auth.core.exceptions.EmailAlreadyExistsException;
import com.github.rod1andrade.lendbookbackend.features.auth.core.exceptions.InvalidUserExcepetion;
import com.github.rod1andrade.lendbookbackend.features.auth.core.ports.AbstractUserInputData;
import com.github.rod1andrade.lendbookbackend.features.auth.core.repositories.IQueryUserRepository;
import com.github.rod1andrade.lendbookbackend.features.auth.core.usecases.interfaces.IValidateUserUsecase;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ValidateUserUsecase implements IValidateUserUsecase {

    private final IQueryUserRepository queryUserRepository;

    @Override
    public void apply(AbstractUserInputData userInputData) throws InvalidUserExcepetion {
        if (
                userInputData.getName() == null
                        || userInputData.getLastName() == null
                        || userInputData.getEmail() == null
                        || userInputData.getPassword() == null
        ) {
            throw new InvalidUserExcepetion("Is necessary: name, lastname, email and password.");
        }

        User user = queryUserRepository.findByEmail(
                userInputData.parserToEntity(null).getEmail()
        );

        if (user != null) throw new EmailAlreadyExistsException("Email already exists");
    }
}
