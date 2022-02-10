package com.github.rod1andrade.lendbookbackend.features.auth.external.factories;

import com.github.rod1andrade.lendbookbackend.features.auth.core.factories.IDispatchConfirmMailUsecaseFactory;
import com.github.rod1andrade.lendbookbackend.features.auth.core.services.IDispatchConfirmMailSevice;
import com.github.rod1andrade.lendbookbackend.features.auth.core.usecases.implementations.DispatchConfirmMailUsecase;
import com.github.rod1andrade.lendbookbackend.features.auth.core.usecases.interfaces.IDispatchConfirmMailUsecase;
import com.github.rod1andrade.lendbookbackend.features.auth.infra.events.IDispatchConfirmMailEvent;
import com.github.rod1andrade.lendbookbackend.features.auth.infra.services.DispatchConfirmMailSevice;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * @author Rodrigo Andrade
 */
@Component
@RequiredArgsConstructor
public class DispatchConfirmMailUsecaseFactory implements IDispatchConfirmMailUsecaseFactory {

    private final IDispatchConfirmMailEvent dispatchConfirmMailEvent;

    @Override
    public IDispatchConfirmMailUsecase create() {
        IDispatchConfirmMailSevice dispatchConfirmMailService = new DispatchConfirmMailSevice(dispatchConfirmMailEvent);
        return new DispatchConfirmMailUsecase(dispatchConfirmMailService);
    }
}
