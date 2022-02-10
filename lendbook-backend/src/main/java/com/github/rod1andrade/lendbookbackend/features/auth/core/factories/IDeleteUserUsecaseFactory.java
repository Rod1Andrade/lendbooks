package com.github.rod1andrade.lendbookbackend.features.auth.core.factories;

import com.github.rod1andrade.lendbookbackend.features.auth.core.usecases.interfaces.IDeleteUserUsecase;

/**
 * @author Rodrigo Andrade
 */
public interface IDeleteUserUsecaseFactory {
    IDeleteUserUsecase create();
}
