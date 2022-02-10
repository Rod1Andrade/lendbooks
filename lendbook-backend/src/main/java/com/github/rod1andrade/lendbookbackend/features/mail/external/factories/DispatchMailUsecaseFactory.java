package com.github.rod1andrade.lendbookbackend.features.mail.external.factories;

import com.github.rod1andrade.lendbookbackend.features.mail.core.factories.IDispatchMailUsecaseFactory;
import com.github.rod1andrade.lendbookbackend.features.mail.core.services.IDispatchMailService;
import com.github.rod1andrade.lendbookbackend.features.mail.core.usecases.implementations.DispatchMailUsecase;
import com.github.rod1andrade.lendbookbackend.features.mail.core.usecases.interfaces.IDispatchMailUsecase;
import com.github.rod1andrade.lendbookbackend.features.mail.infra.events.IDispatchMailEvent;
import com.github.rod1andrade.lendbookbackend.features.mail.infra.services.DispatchMailService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DispatchMailUsecaseFactory implements IDispatchMailUsecaseFactory {

    private final IDispatchMailEvent dispatchMailEvent;

    @Override
    public IDispatchMailUsecase create() {
        IDispatchMailService dispatchMailService = new DispatchMailService(dispatchMailEvent);
        return new DispatchMailUsecase(dispatchMailService);
    }
}
