package com.github.rod1andrade.lendbookbackend.features.auth.core.services;

import com.github.rod1andrade.lendbookbackend.features.auth.core.entities.ConfirmAccountMail;
import com.github.rod1andrade.lendbookbackend.features.auth.core.exceptions.DispatchConfirmMailSeviceException;

/**
 * @author Rodrigo Andrade
 */
public interface IDispatchConfirmMailSevice {
    void apply(ConfirmAccountMail confirmAccountMail) throws DispatchConfirmMailSeviceException;
}
