package com.github.rod1andrade.lendbookbackend.features.auth.external.models;

import lombok.*;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MailModel implements Serializable {
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
