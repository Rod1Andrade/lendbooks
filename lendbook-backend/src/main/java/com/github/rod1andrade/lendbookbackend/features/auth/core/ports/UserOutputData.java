package com.github.rod1andrade.lendbookbackend.features.auth.core.ports;

import com.github.rod1andrade.lendbookbackend.features.auth.core.entities.User;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@NoArgsConstructor
public class UserOutputData extends AbstractUserOutputData {
    @Override
    public AbstractUserOutputData parserTo(User user) {
        return new UserOutputDataBuilderImpl()
                .name(user.getFullName().getFirstName())
                .lastName(user.getFullName().getLastName())
                .email(user.getEmail().getValue())
                .token(user.getStatus().getToken())
                .build();
    }
}
