package com.github.rod1andrade.lendbookbackend.features.auth.core.entities;

import com.github.rod1andrade.lendbookbackend.features.auth.core.valueobjects.Email;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Rodrigo Andrade
 */
@AllArgsConstructor
@NoArgsConstructor
public class ConfirmAccountMail {
    @Getter
    @Setter
    private Email mailTo;

    @Getter
    @Setter
    private String subject;

    @Getter
    @Setter
    private String text;
}
