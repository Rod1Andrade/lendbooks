package com.github.rod1andrade.lendbookbackend.features.auth.core.factories;

import com.github.rod1andrade.lendbookbackend.features.auth.core.usecases.interfaces.IActiveRegisteredUserByTokenUsecase;

/**
 * @author Rodrigo Andrade
 */
public interface IActiveRegisterdUserByTokenFactory {
    IActiveRegisteredUserByTokenUsecase create();
}
