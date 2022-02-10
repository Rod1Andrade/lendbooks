package com.github.rod1andrade.lendbookbackend.features.mail.core.factories;

import com.github.rod1andrade.lendbookbackend.features.mail.core.usecases.interfaces.IDispatchMailUsecase;

/**
 * @author Rodrigo Andrade
 */
public interface IDispatchMailUsecaseFactory {

    IDispatchMailUsecase create();

}
