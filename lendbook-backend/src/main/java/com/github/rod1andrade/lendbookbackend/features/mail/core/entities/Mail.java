package com.github.rod1andrade.lendbookbackend.features.mail.core.entities;

import lombok.*;

/**
 * @author Rodrigo Andrade
 */
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Mail {

    @Getter
    @Setter
    private String mailTo;

    @Getter
    @Setter
    private String subject;

    @Getter
    @Setter
    private String text;

}
