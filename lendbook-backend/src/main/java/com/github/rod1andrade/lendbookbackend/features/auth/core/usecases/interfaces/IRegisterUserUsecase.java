package com.github.rod1andrade.lendbookbackend.features.auth.core.usecases.interfaces;

import com.github.rod1andrade.lendbookbackend.features.auth.core.ports.AbstractUserInputData;
import com.github.rod1andrade.lendbookbackend.features.auth.core.ports.AbstractUserOutputData;

import java.util.function.UnaryOperator;

/**
 * @author Rodrigo Andrade
 */
public interface IRegisterUserUsecase {
    void apply(AbstractUserInputData userInputData, UnaryOperator<String> encodeFunction);

    AbstractUserOutputData getOutputDate();
}
