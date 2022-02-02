package com.github.rod1andrade.lendbookbackend.features.auth.core.usecases.implementations;

import com.github.rod1andrade.lendbookbackend.features.auth.core.exceptions.CommandRepositoryException;
import com.github.rod1andrade.lendbookbackend.features.auth.core.exceptions.RegisterUserExcepion;
import com.github.rod1andrade.lendbookbackend.features.auth.core.ports.AbstractUserInputData;
import com.github.rod1andrade.lendbookbackend.features.auth.core.ports.AbstractUserOutputData;
import com.github.rod1andrade.lendbookbackend.features.auth.core.ports.UserOutputData;
import com.github.rod1andrade.lendbookbackend.features.auth.core.repositories.ICommandUserRepository;
import com.github.rod1andrade.lendbookbackend.features.auth.core.usecases.interfaces.IRegisterUserUsecase;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.function.Function;

/**
 * @author Rodrigo Andrade
 */
@RequiredArgsConstructor
public class RegisterUserUsecase implements IRegisterUserUsecase {

    @Getter
    private final ICommandUserRepository commandUserRepository;

    private AbstractUserInputData userInputData;

    @Override
    public void apply(AbstractUserInputData userInputData, Function<String, String> encodeFunction) {
        this.userInputData = userInputData;
        try {
            commandUserRepository.save(userInputData.parserToEntity(encodeFunction));
        } catch (CommandRepositoryException e) {
            throw new RegisterUserExcepion(e.getMessage());
        }
    }

    @Override
    public AbstractUserOutputData getOutputDate() {
        return new UserOutputData()
                .parserTo(
                        userInputData.parserToEntity(null)
                );
    }
}
