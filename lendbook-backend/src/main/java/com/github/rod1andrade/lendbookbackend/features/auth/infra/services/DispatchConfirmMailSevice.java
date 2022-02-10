package com.github.rod1andrade.lendbookbackend.features.auth.infra.services;

import com.github.rod1andrade.lendbookbackend.features.auth.core.entities.ConfirmAccountMail;
import com.github.rod1andrade.lendbookbackend.features.auth.core.services.IDispatchConfirmMailSevice;
import com.github.rod1andrade.lendbookbackend.features.auth.infra.events.IDispatchConfirmMailEvent;
import lombok.RequiredArgsConstructor;

/**
 * @author Rodrigo Andrade
 */
@RequiredArgsConstructor
public class DispatchConfirmMailSevice implements IDispatchConfirmMailSevice {

    private final IDispatchConfirmMailEvent dispatchConfirmMailEvent;

    @Override
    public void apply(ConfirmAccountMail confirmAccountMail) {
        dispatchConfirmMailEvent.apply(confirmAccountMail);
    }
}
