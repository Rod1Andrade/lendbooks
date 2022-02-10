package com.github.rod1andrade.lendbookbackend.features.auth.core.usecases.implementations;

import com.github.rod1andrade.lendbookbackend.features.auth.core.entities.ConfirmAccountMail;
import com.github.rod1andrade.lendbookbackend.features.auth.core.exceptions.ImpossibleSendMailException;
import com.github.rod1andrade.lendbookbackend.features.auth.core.services.IDispatchConfirmMailSevice;
import com.github.rod1andrade.lendbookbackend.features.auth.core.usecases.interfaces.IDispatchConfirmMailUsecase;
import lombok.RequiredArgsConstructor;

/**
 * @author Rodrigo Andrade
 */
@RequiredArgsConstructor
public class DispatchConfirmMailUsecase implements IDispatchConfirmMailUsecase {

    private final IDispatchConfirmMailSevice dispatchConfirmMailSevice;

    @Override
    public void apply(ConfirmAccountMail confirmAccountMail) throws ImpossibleSendMailException {
        dispatchConfirmMailSevice.apply(confirmAccountMail);
    }
}
