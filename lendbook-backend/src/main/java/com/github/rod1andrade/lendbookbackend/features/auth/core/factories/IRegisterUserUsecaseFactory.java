package com.github.rod1andrade.lendbookbackend.features.auth.core.factories;

import com.github.rod1andrade.lendbookbackend.features.auth.core.usecases.interfaces.IRegisterUserUsecase;

/**
 * @author Rodrigo Andrade
 */
public interface IRegisterUserUsecaseFactory {
    IRegisterUserUsecase create();
}
