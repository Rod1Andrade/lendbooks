package com.github.rod1andrade.lendbookbackend.features.mail.infra.events;

import com.github.rod1andrade.lendbookbackend.features.mail.core.entities.Mail;

/**
 * @author Rodrigo Andrade
 */
public interface IDispatchMailEvent {
    void send(Mail mail);
}
