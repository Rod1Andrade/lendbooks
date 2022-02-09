package com.github.rod1andrade.lendbookbackend.features.mail.core.usecases.interfaces;

import com.github.rod1andrade.lendbookbackend.features.mail.core.entities.Mail;

/**
 * @author Rodrigo Andrade
 */
public interface IDispatchMailUsecase {
    void apply(Mail mail);
}
