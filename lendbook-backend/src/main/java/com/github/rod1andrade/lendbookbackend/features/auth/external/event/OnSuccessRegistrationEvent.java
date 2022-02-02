package com.github.rod1andrade.lendbookbackend.features.auth.external.event;

import com.github.rod1andrade.lendbookbackend.features.auth.core.ports.AbstractUserOutputData;
import lombok.Getter;
import org.springframework.context.ApplicationEvent;

public class OnSuccessRegistrationEvent extends ApplicationEvent {

    @Getter
    private final AbstractUserOutputData outputData;

    @Getter
    private final String appUrl;

    public OnSuccessRegistrationEvent(AbstractUserOutputData outputData, String appUrl) {
        super(outputData);
        this.outputData = outputData;
        this.appUrl = appUrl;
    }
}
