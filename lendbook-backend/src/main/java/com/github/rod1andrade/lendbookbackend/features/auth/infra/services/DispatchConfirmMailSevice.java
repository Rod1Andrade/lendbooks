package com.github.rod1andrade.lendbookbackend.features.auth.infra.services;

import com.github.rod1andrade.lendbookbackend.features.auth.core.entities.ConfirmAccountMail;
import com.github.rod1andrade.lendbookbackend.features.auth.core.exceptions.DispatchConfirmMailSeviceException;
import com.github.rod1andrade.lendbookbackend.features.auth.core.services.IDispatchConfirmMailSevice;
import com.github.rod1andrade.lendbookbackend.features.auth.infra.events.IDispatchConfirmMailEvent;
import com.github.rod1andrade.lendbookbackend.features.auth.infra.exceptions.DispatchConfirmMailEventException;
import lombok.RequiredArgsConstructor;

/**
 * @author Rodrigo Andrade
 */
@RequiredArgsConstructor
public class DispatchConfirmMailSevice implements IDispatchConfirmMailSevice {

    private final IDispatchConfirmMailEvent dispatchConfirmMailEvent;

    @Override
    public void apply(ConfirmAccountMail confirmAccountMail) {
        try {
            dispatchConfirmMailEvent.apply(confirmAccountMail);
        } catch (DispatchConfirmMailEventException e) {
            throw new DispatchConfirmMailSeviceException(e.getMessage());
        }
        catch (Exception e) {
            throw new DispatchConfirmMailSeviceException("Erro desconhecido.");
        }
    }
}
