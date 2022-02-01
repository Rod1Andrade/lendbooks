package com.github.rod1andrade.lendbookbackend.features.auth.external.event;

import com.github.rod1andrade.lendbookbackend.features.auth.core.entities.User;
import lombok.Getter;
import org.springframework.context.ApplicationEvent;

public class OnSuccessRegistrationEvent extends ApplicationEvent {

    @Getter
    private final User user;

    @Getter
    private final String appUrl;

    public OnSuccessRegistrationEvent(User user, String appUrl) {
        super(user);
        this.user = user;
        this.appUrl = appUrl;
    }
}
