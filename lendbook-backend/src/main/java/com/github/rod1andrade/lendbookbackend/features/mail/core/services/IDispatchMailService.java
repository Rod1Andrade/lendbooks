package com.github.rod1andrade.lendbookbackend.features.mail.core.services;

import com.github.rod1andrade.lendbookbackend.features.mail.core.entities.Mail;

/**
 * @author Rodrigo Andrade
 */
public interface IDispatchMailService {

    void send(Mail mail);

}
