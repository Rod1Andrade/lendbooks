package com.github.rod1andrade.lendbookbackend.features.auth.core.usecases.implementations;

import com.github.rod1andrade.lendbookbackend.features.auth.core.entities.Status;
import com.github.rod1andrade.lendbookbackend.features.auth.core.enums.UserStatus;
import com.github.rod1andrade.lendbookbackend.features.auth.core.exceptions.ActiveRegisteredUserByTokenException;
import com.github.rod1andrade.lendbookbackend.features.auth.core.repositories.ICommandStatusRepository;
import com.github.rod1andrade.lendbookbackend.features.auth.core.usecases.interfaces.IActiveRegisteredUserByTokenUsecase;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.Instant;
import java.util.Optional;

/**
 * @author Rodrigo Andrade
 */
@RequiredArgsConstructor
public class ActiveRegisteredUserByTokenUsecase implements IActiveRegisteredUserByTokenUsecase {

    @Getter
    private final ICommandStatusRepository commandStatusRepository;

    @Override
    public void apply(String token) throws ActiveRegisteredUserByTokenException {
        Optional<Status> optionalStatus = Optional.ofNullable(commandStatusRepository.findStatusByToken(token));

        optionalStatus.ifPresentOrElse(
                value -> {
                    if(Instant.now().isBefore(value.getExpiryTime())) {
                        value.setUserStatus(UserStatus.ACTIVATE);
                        commandStatusRepository.save(value);
                    } else {
                        throw new ActiveRegisteredUserByTokenException("Token is not valid: expiryd time.");
                    }
                }
                , () -> {
                    throw new ActiveRegisteredUserByTokenException("Token doesn't exists");
                }
        );
    }
}
