package com.github.rod1andrade.lendbookbackend.features.auth.core.usecases.interfaces;

import com.github.rod1andrade.lendbookbackend.features.auth.core.entities.ConfirmAccountMail;
import com.github.rod1andrade.lendbookbackend.features.auth.core.exceptions.ImpossibleSendMailException;

/**
 * @author Rodrigo Andrade
 */
public interface IDispatchConfirmMailUsecase {
    void apply(ConfirmAccountMail confirmAccountMail) throws ImpossibleSendMailException;
}
