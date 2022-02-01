package com.github.rod1andrade.lendbookbackend.features.auth.core.repositories;

import com.github.rod1andrade.lendbookbackend.features.auth.core.entities.User;
import com.github.rod1andrade.lendbookbackend.features.auth.core.exceptions.CommandRepositoryException;

/**
 * @author Rodrigo Andrade
 */
public interface ICommandUserRepository {
    void save(User user) throws CommandRepositoryException;
}
