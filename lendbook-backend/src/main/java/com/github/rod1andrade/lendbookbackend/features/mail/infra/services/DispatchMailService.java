package com.github.rod1andrade.lendbookbackend.features.mail.infra.services;

import com.github.rod1andrade.lendbookbackend.features.mail.core.entities.Mail;
import com.github.rod1andrade.lendbookbackend.features.mail.core.services.IDispatchMailService;
import com.github.rod1andrade.lendbookbackend.features.mail.infra.events.IDispatchMailEvent;
import lombok.RequiredArgsConstructor;

/**
 * @author Rodrigo Andrade
 */
@RequiredArgsConstructor
public class DispatchMailService implements IDispatchMailService {

    private final IDispatchMailEvent dispatchMailEvent;

    @Override
    public void send(Mail mail) {
        dispatchMailEvent.send(mail);
    }
}
