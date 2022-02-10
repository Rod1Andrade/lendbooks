package com.github.rod1andrade.lendbookbackend.features.auth.infra.datasource;

import com.github.rod1andrade.lendbookbackend.features.auth.core.entities.User;
import com.github.rod1andrade.lendbookbackend.features.auth.infra.exceptions.CommandUserDatasourceException;

/**
 * @author Rodrigo Andrade
 */
public interface ICommandUserDatasource {
    void save(User user) throws CommandUserDatasourceException;

    void delete(User user) throws CommandUserDatasourceException;
}
