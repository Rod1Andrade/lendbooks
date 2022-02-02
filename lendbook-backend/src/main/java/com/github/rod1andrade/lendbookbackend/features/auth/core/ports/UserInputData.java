package com.github.rod1andrade.lendbookbackend.features.auth.core.ports;

import com.github.rod1andrade.lendbookbackend.features.auth.core.entities.Status;
import com.github.rod1andrade.lendbookbackend.features.auth.core.entities.User;
import com.github.rod1andrade.lendbookbackend.features.auth.core.enums.UserStatus;
import com.github.rod1andrade.lendbookbackend.features.auth.core.valueobjects.Email;
import com.github.rod1andrade.lendbookbackend.features.auth.core.valueobjects.FullName;
import com.github.rod1andrade.lendbookbackend.features.auth.core.valueobjects.Password;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.Random;
import java.util.UUID;
import java.util.function.Function;

/**
 * @author Rodrigo Andrade
 */
@SuperBuilder
@NoArgsConstructor
public class UserInputData extends AbstractUserInputData {
    @Override
    public User parserToEntity(Function<String, String> encodeFunction) {
        var fullName = new FullName(getName(), getLastName());
        var password = new Password(getPassword());

        if (encodeFunction != null)
            password.encode(encodeFunction);

        var email = new Email(getEmail());

        if(getToken() == null) setToken(UUID.randomUUID().toString());
        var status = new Status(getToken(), UserStatus.UNACTIVATE);

        return new User(null, fullName, email, password, status);
    }
}
