package com.github.rod1andrade.lendbookbackend.features.auth.core.factories;

import com.github.rod1andrade.lendbookbackend.features.auth.core.usecases.interfaces.IAuthenticateUserUsecase;

import java.util.function.BiPredicate;

/**
 * @author Rodrigo Andrade
 */
public interface IAuthenticateUserUsecaseFactory {
    IAuthenticateUserUsecase create(BiPredicate<String, String> compareFunctions);
}
