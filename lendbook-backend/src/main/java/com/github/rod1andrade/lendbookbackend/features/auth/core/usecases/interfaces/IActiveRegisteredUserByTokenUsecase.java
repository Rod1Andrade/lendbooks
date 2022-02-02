package com.github.rod1andrade.lendbookbackend.features.auth.core.usecases.interfaces;

import com.github.rod1andrade.lendbookbackend.features.auth.core.exceptions.ActiveRegisteredUserByTokenException;

/**
 * @author Rodrigo Andrade
 */
public interface IActiveRegisteredUserByTokenUsecase {
    void apply(String token) throws ActiveRegisteredUserByTokenException;
}
