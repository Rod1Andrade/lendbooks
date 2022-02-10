package com.github.rod1andrade.lendbookbackend.features.auth.core.services;

import com.github.rod1andrade.lendbookbackend.features.auth.core.entities.ConfirmAccountMail;

/**
 * @author Rodrigo Andrade
 */
public interface IDispatchConfirmMailSevice {
    void apply(ConfirmAccountMail confirmAccountMail);
}
