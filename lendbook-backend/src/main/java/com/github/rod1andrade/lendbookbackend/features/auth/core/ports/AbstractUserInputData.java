package com.github.rod1andrade.lendbookbackend.features.auth.core.ports;

import com.github.rod1andrade.lendbookbackend.features.auth.core.entities.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.function.UnaryOperator;

/**
 * @author Rodrigo Andrade
 */
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public abstract class AbstractUserInputData {
    @Getter
    @Setter
    protected String name;

    @Getter
    @Setter
    protected String lastName;

    @Getter
    @Setter
    protected String email;

    @Getter
    @Setter
    protected String password;

    @Getter
    @Setter
    protected String token;

    public abstract User parserToEntity(UnaryOperator<String> encodeFunction);
}
