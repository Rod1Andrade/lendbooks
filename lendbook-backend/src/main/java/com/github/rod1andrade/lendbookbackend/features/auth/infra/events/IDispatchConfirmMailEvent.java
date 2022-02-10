package com.github.rod1andrade.lendbookbackend.features.auth.infra.events;

import com.github.rod1andrade.lendbookbackend.features.auth.core.entities.ConfirmAccountMail;

/**
 * @author Rodrigo Andrade
 */
public interface IDispatchConfirmMailEvent {
    void apply(ConfirmAccountMail confirmAccountMail);
}
