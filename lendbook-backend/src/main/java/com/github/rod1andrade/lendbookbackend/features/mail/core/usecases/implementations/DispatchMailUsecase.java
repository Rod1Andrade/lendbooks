package com.github.rod1andrade.lendbookbackend.features.mail.core.usecases.implementations;

import com.github.rod1andrade.lendbookbackend.features.mail.core.entities.Mail;
import com.github.rod1andrade.lendbookbackend.features.mail.core.exceptions.DispatchMailException;
import com.github.rod1andrade.lendbookbackend.features.mail.core.exceptions.DispatchMailServiceException;
import com.github.rod1andrade.lendbookbackend.features.mail.core.services.IDispatchMailService;
import com.github.rod1andrade.lendbookbackend.features.mail.core.usecases.interfaces.IDispatchMailUsecase;
import lombok.RequiredArgsConstructor;

/**
 * @author Rodrigo Andrade
 */
@RequiredArgsConstructor
public class DispatchMailUsecase implements IDispatchMailUsecase {

    private final IDispatchMailService dispatchMailService;

    @Override
    public void apply(Mail mail) throws DispatchMailException {
        try {
            dispatchMailService.send(mail);
        } catch (DispatchMailServiceException e) {
            throw new DispatchMailException(e.getMessage());
        } catch (Exception e) {
            throw new DispatchMailException("Erro desconhecido.");
        }
    }
}
