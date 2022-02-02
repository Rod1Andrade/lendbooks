package com.github.rod1andrade.lendbookbackend.features.auth.infra.repositories;

import com.github.rod1andrade.lendbookbackend.features.auth.core.entities.Status;
import com.github.rod1andrade.lendbookbackend.features.auth.core.exceptions.CommandStatusRepositoryException;
import com.github.rod1andrade.lendbookbackend.features.auth.core.repositories.ICommandStatusRepository;
import com.github.rod1andrade.lendbookbackend.features.auth.infra.datasource.ICommandStatusDatasource;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * @author Rodrigo Andrade
 */
@RequiredArgsConstructor
public class CommandStatusRepository implements ICommandStatusRepository {

    @Getter
    private final ICommandStatusDatasource commandStatusDatasource;

    @Override
    public Status findStatusByToken(String token) throws CommandStatusRepositoryException {
        return commandStatusDatasource.findStatusByToken(token);
    }

    @Override
    public void save(Status status) throws CommandStatusRepositoryException {
        commandStatusDatasource.save(status);
    }
}
