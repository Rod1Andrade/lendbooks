package com.github.rod1andrade.lendbookbackend.features.auth.core.usecases.interfaces;

import com.github.rod1andrade.lendbookbackend.features.auth.core.exceptions.DeleteUserException;
import com.github.rod1andrade.lendbookbackend.features.auth.core.ports.AbstractUserInputData;

/**
 * @author Rodrigo Andrade
 */
public interface IDeleteUserUsecase {
    void apply(AbstractUserInputData userInputData) throws DeleteUserException;
}
