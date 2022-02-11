package com.github.rod1andrade.lendbookbackend.features.auth.core.ports;

import com.github.rod1andrade.lendbookbackend.features.auth.core.entities.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;

/**
 * @author Rodrigo Andrade
 */
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public abstract class AbstractUserOutputData implements Serializable {
    @Getter
    @Setter
    private String name;

    @Getter
    @Setter
    private String lastName;

    @Getter
    @Setter
    private String email;

    @Getter
    @Setter
    private String token;

    public abstract AbstractUserOutputData parserTo(User user);
}
