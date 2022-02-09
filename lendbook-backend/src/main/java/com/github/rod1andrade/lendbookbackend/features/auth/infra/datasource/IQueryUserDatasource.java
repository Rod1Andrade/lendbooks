package com.github.rod1andrade.lendbookbackend.features.auth.infra.datasource;

import com.github.rod1andrade.lendbookbackend.features.auth.core.entities.User;
import com.github.rod1andrade.lendbookbackend.features.auth.core.valueobjects.Email;
import com.github.rod1andrade.lendbookbackend.features.auth.infra.exceptions.QueryUserDatasourceException;

/**
 * @author Rodrigo Andrade
 */
public interface IQueryUserDatasource {
    User findByEmail(Email email) throws QueryUserDatasourceException;
}
