package com.github.rod1andrade.lendbookbackend.features.auth.core.repositories;

import com.github.rod1andrade.lendbookbackend.features.auth.core.entities.User;
import com.github.rod1andrade.lendbookbackend.features.auth.core.valueobjects.Email;

/**
 * @author Rodrig Andrade
 */
public interface IQueryUserRepository {
    User findByEmail(Email email);
}
