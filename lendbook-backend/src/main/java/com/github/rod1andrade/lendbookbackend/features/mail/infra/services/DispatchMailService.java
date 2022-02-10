package com.github.rod1andrade.lendbookbackend.features.mail.infra.services;

import com.github.rod1andrade.lendbookbackend.features.mail.core.entities.Mail;
import com.github.rod1andrade.lendbookbackend.features.mail.core.exceptions.DispatchMailServiceException;
import com.github.rod1andrade.lendbookbackend.features.mail.core.services.IDispatchMailService;
import com.github.rod1andrade.lendbookbackend.features.mail.infra.events.IDispatchMailEvent;
import com.github.rod1andrade.lendbookbackend.features.mail.infra.exceptions.DispatchMailEventException;
import lombok.RequiredArgsConstructor;

/**
 * @author Rodrigo Andrade
 */
@RequiredArgsConstructor
public class DispatchMailService implements IDispatchMailService {

    private final IDispatchMailEvent dispatchMailEvent;

    @Override
    public void send(Mail mail) {
        try {
            dispatchMailEvent.send(mail);
        } catch (DispatchMailEventException e) {
            throw new DispatchMailServiceException(e.getMessage());
        } catch (Exception e) {
            throw new DispatchMailServiceException("Erro desconhecido.");
        }
    }
}
