package com.github.rod1andrade.lendbookbackend.features.mail.core.services;

import com.github.rod1andrade.lendbookbackend.features.mail.core.entities.Mail;
import com.github.rod1andrade.lendbookbackend.features.mail.core.exceptions.DispatchMailServiceException;

/**
 * @author Rodrigo Andrade
 */
public interface IDispatchMailService {

    void send(Mail mail) throws DispatchMailServiceException;

}
