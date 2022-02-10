package com.github.rod1andrade.lendbookbackend.features.mail.core.usecases.interfaces;

import com.github.rod1andrade.lendbookbackend.features.mail.core.entities.Mail;
import com.github.rod1andrade.lendbookbackend.features.mail.core.exceptions.DispatchMailException;

/**
 * @author Rodrigo Andrade
 */
public interface IDispatchMailUsecase {
    void apply(Mail mail) throws DispatchMailException;
}
