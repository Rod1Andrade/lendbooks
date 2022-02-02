package com.github.rod1andrade.lendbookbackend.features.auth.infra.datasource;

import com.github.rod1andrade.lendbookbackend.features.auth.core.entities.Status;
import com.github.rod1andrade.lendbookbackend.features.auth.infra.exceptions.CommandStatusDatasourceException;

/**
 * @author Rodrigo Andrade
 */
public interface ICommandStatusDatasource {
    Status findStatusByToken(String token) throws CommandStatusDatasourceException;

    void save(Status status) throws CommandStatusDatasourceException;
}
