package com.github.rod1andrade.lendbookbackend.features.auth.core.factories;

import com.github.rod1andrade.lendbookbackend.features.auth.core.usecases.interfaces.IValidateUserUsecase;

/**
 * @author Rodrigo Andrade
 */
public interface IValidateUserUsecaseFactory {
    IValidateUserUsecase create();
}
