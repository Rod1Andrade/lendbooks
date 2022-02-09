package com.github.rod1andrade.lendbookbackend.features.auth.infra.repositories;

import com.github.rod1andrade.lendbookbackend.features.auth.core.entities.User;
import com.github.rod1andrade.lendbookbackend.features.auth.core.exceptions.QueryRepositoryException;
import com.github.rod1andrade.lendbookbackend.features.auth.core.repositories.IQueryUserRepository;
import com.github.rod1andrade.lendbookbackend.features.auth.core.valueobjects.Email;
import com.github.rod1andrade.lendbookbackend.features.auth.infra.datasource.IQueryUserDatasource;
import com.github.rod1andrade.lendbookbackend.features.auth.infra.exceptions.QueryUserDatasourceException;
import lombok.RequiredArgsConstructor;

/**
 * @author Rodrigo Andrade
 */
@RequiredArgsConstructor
public class QueryUserRepository implements IQueryUserRepository {

    private final IQueryUserDatasource queryUserDatasource;

    @Override
    public User findByEmail(Email email) {
        try {
            return queryUserDatasource.findByEmail(email);
        } catch (QueryUserDatasourceException e) {
            throw new QueryRepositoryException(e.getMessage());
        } catch (Exception e) {
            throw new QueryRepositoryException("Something wrong.");
        }
    }
}
