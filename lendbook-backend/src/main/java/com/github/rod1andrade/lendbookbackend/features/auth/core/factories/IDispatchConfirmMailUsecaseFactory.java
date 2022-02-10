package com.github.rod1andrade.lendbookbackend.features.auth.core.factories;

import com.github.rod1andrade.lendbookbackend.features.auth.core.usecases.interfaces.IDispatchConfirmMailUsecase;

/**
 * @author Rodrigo Andrade
 */
public interface IDispatchConfirmMailUsecaseFactory {
    IDispatchConfirmMailUsecase create();
}
