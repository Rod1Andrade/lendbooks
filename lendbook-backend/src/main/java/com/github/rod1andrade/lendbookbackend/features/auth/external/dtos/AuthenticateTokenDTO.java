package com.github.rod1andrade.lendbookbackend.features.auth.external.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
public class AuthenticateTokenDTO implements Serializable {
    @Getter
    @Setter
    private String token;

    @Getter
    @Setter
    private String refreshToken;
}
