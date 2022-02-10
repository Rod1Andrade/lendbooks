package com.github.rod1andrade.lendbookbackend.features.auth.external.factories;

import com.github.rod1andrade.lendbookbackend.features.auth.core.entities.ConfirmAccountMail;
import com.github.rod1andrade.lendbookbackend.features.auth.core.factories.IConfirmMailFactory;
import com.github.rod1andrade.lendbookbackend.features.auth.core.valueobjects.Email;
import org.springframework.stereotype.Component;

/**
 * @author Rodrigo Andrade
 */
@Component
public class ConfirmMailFactory implements IConfirmMailFactory {

    @Override
    public ConfirmAccountMail create(String mailTo, String host, String token) {
        return new ConfirmAccountMail(
                new Email(mailTo),
                "LeendBooks: Confirmação de Email.",
                "Para confirmar a sua conta, por favor clique no link: " + host + "/auth" +
                        "/confirmAccount?token=" + token
        );
    }
}
