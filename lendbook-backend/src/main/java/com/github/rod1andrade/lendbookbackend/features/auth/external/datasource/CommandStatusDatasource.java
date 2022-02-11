package com.github.rod1andrade.lendbookbackend.features.auth.external.datasource;

import com.github.rod1andrade.lendbookbackend.features.auth.core.entities.Status;
import com.github.rod1andrade.lendbookbackend.features.auth.core.enums.UserStatus;
import com.github.rod1andrade.lendbookbackend.features.auth.external.enums.UserModelStatus;
import com.github.rod1andrade.lendbookbackend.features.auth.external.models.StatusModel;
import com.github.rod1andrade.lendbookbackend.features.auth.external.repositories.StatusModelRepository;
import com.github.rod1andrade.lendbookbackend.features.auth.infra.datasource.ICommandStatusDatasource;
import com.github.rod1andrade.lendbookbackend.features.auth.infra.exceptions.CommandStatusDatasourceException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.persistence.PersistenceException;
import java.util.Optional;

/**
 * @author Rodrigo Andrade
 */
@Component
@RequiredArgsConstructor
@Slf4j
public class CommandStatusDatasource implements ICommandStatusDatasource {

    private final StatusModelRepository statusModelRepository;

    @Override
    public Status findStatusByToken(String token) throws CommandStatusDatasourceException {
        Optional<StatusModel> statusModelOptional = Optional.ofNullable(statusModelRepository.findByToken(token));
        var statusModel = statusModelOptional.orElseThrow(() -> {
                    throw new CommandStatusDatasourceException("Token doesn't exists.");
                }
        );

        return new Status(
                statusModel.getId(),
                statusModel.getToken(),
                statusModel.getCreateAt(),
                statusModel.getExpiryTime(),
                UserStatus.valueOf(statusModel.getStatus().getCode())
        );
    }

    @Override
    public void save(Status status) throws CommandStatusDatasourceException {
        Optional<StatusModel> statusModelOptional = Optional.of(statusModelRepository.save(
                StatusModel.builder()
                        .id(status.getId())
                        .status(UserModelStatus.valueOf(status.getUserStatus().getCode()))
                        .token(status.getToken())
                        .createAt(status.getCreateAt())
                        .expiryTime(status.getExpiryTime())
                        .build()
        ));

        statusModelOptional.ifPresentOrElse(value -> log.info("Saved: {} with success", value), () -> {
            log.info("Something wrong");
            throw new PersistenceException("Is not possible validate this token.");
        });
    }
}
