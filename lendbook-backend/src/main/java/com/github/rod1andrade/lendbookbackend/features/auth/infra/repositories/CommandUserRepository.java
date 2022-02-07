package com.github.rod1andrade.lendbookbackend.features.auth.infra.repositories;

import com.github.rod1andrade.lendbookbackend.features.auth.core.entities.User;
import com.github.rod1andrade.lendbookbackend.features.auth.core.exceptions.CommandRepositoryException;
import com.github.rod1andrade.lendbookbackend.features.auth.core.repositories.ICommandUserRepository;
import com.github.rod1andrade.lendbookbackend.features.auth.infra.datasource.ICommandUserDatasource;
import com.github.rod1andrade.lendbookbackend.features.auth.infra.exceptions.CommandUserDatasourceException;
import lombok.RequiredArgsConstructor;

/**
 * @author Rodrigo Andrade
 */
@RequiredArgsConstructor
public class CommandUserRepository implements ICommandUserRepository {

    private final ICommandUserDatasource commandUserDatasource;

    @Override
    public void save(User user) throws CommandRepositoryException {
        try {
            commandUserDatasource.save(user);
        } catch (CommandUserDatasourceException e) {
            throw new CommandRepositoryException(e.getMessage());
        } catch (Exception e) {
            throw new CommandRepositoryException("Erro inesperado.");
        }
    }
}
