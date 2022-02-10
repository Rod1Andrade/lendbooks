package com.github.rod1andrade.lendbookbackend.features.auth.core.usecases.interfaces;

import com.github.rod1andrade.lendbookbackend.features.auth.core.exceptions.DeleteUserException;
import com.github.rod1andrade.lendbookbackend.features.auth.core.ports.UserInputData;

/**
 * @author Rodrigo Andrade
 */
public interface IDeleteUserUsecase {
    void apply(UserInputData userInputData) throws DeleteUserException;
}
