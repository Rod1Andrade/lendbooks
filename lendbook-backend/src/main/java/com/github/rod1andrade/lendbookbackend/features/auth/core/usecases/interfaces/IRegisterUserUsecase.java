package com.github.rod1andrade.lendbookbackend.features.auth.core.usecases.interfaces;

import com.github.rod1andrade.lendbookbackend.features.auth.core.ports.AbstractUserInputData;
import com.github.rod1andrade.lendbookbackend.features.auth.core.ports.AbstractUserOutputData;

import java.util.function.Function;

/**
 * @author Rodrigo Andrade
 */
public interface IRegisterUserUsecase {
    void apply(AbstractUserInputData userInputData, Function<String, String> encode);
    AbstractUserOutputData getOutputDate();
}
