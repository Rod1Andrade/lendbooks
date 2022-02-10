package com.github.rod1andrade.lendbookbackend.features.auth.core.factories;

import com.github.rod1andrade.lendbookbackend.features.auth.core.entities.ConfirmAccountMail;

public interface IConfirmMailFactory {
    ConfirmAccountMail create(String mailTo, String host, String token);
}
