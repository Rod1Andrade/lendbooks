package com.github.rod1andrade.lendbookbackend.features.auth.core.usecases.interfaces;

import com.github.rod1andrade.lendbookbackend.features.auth.core.exceptions.InvalidUserExcepetion;
import com.github.rod1andrade.lendbookbackend.features.auth.core.ports.AbstractUserInputData;

/**
 * @author Rodrigo Andrade
 */
public interface IValidateUserUsecase {
    void apply(AbstractUserInputData user) throws InvalidUserExcepetion;
}
