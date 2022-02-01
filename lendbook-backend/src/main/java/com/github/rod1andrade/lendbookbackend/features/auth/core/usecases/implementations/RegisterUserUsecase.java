package com.github.rod1andrade.lendbookbackend.features.auth.core.usecases.implementations;

import com.github.rod1andrade.lendbookbackend.features.auth.core.entities.User;
import com.github.rod1andrade.lendbookbackend.features.auth.core.exceptions.CommandRepositoryException;
import com.github.rod1andrade.lendbookbackend.features.auth.core.exceptions.RegisterUserExcepion;
import com.github.rod1andrade.lendbookbackend.features.auth.core.repositories.ICommandUserRepository;
import com.github.rod1andrade.lendbookbackend.features.auth.core.usecases.interfaces.IRegisterUserUsecase;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * @author Rodrigo Andrade
 */
@RequiredArgsConstructor
public class RegisterUserUsecase implements IRegisterUserUsecase {

    @Getter
    private final ICommandUserRepository ICommandUserRepository;

    @Override
    public void apply(User user) {
        try {
            ICommandUserRepository.save(user);
        } catch (CommandRepositoryException e) {
            throw new RegisterUserExcepion(e.getMessage());
        }
    }
}
