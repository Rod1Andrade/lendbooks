package com.github.rod1andrade.lendbookbackend.features.auth.core.usecases.interfaces;

import com.github.rod1andrade.lendbookbackend.features.auth.core.entities.User;

/**
 * @author Rodrigo Andrade
 */
public interface IRegisterUserUsecase {
    void apply(User user);
}
