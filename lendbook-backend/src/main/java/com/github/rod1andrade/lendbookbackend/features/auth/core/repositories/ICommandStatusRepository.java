package com.github.rod1andrade.lendbookbackend.features.auth.core.repositories;

import com.github.rod1andrade.lendbookbackend.features.auth.core.entities.Status;
import com.github.rod1andrade.lendbookbackend.features.auth.core.exceptions.CommandStatusRepositoryException;

/**
 * @author Rodrigo Andrade
 */
public interface ICommandStatusRepository {
    Status findStatusByToken(String token) throws CommandStatusRepositoryException;

    void save(Status status)  throws CommandStatusRepositoryException;
}
