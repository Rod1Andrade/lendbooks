package com.github.rod1andrade.lendbookbackend.features.auth.external.factories;

import com.github.rod1andrade.lendbookbackend.features.auth.core.factories.IAuthenticateUserUsecaseFactory;
import com.github.rod1andrade.lendbookbackend.features.auth.core.usecases.implementations.AuthenticateUserUsecase;
import com.github.rod1andrade.lendbookbackend.features.auth.core.usecases.interfaces.IAuthenticateUserUsecase;
import com.github.rod1andrade.lendbookbackend.features.auth.infra.datasource.IQueryUserDatasource;
import com.github.rod1andrade.lendbookbackend.features.auth.infra.repositories.QueryUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.function.BiPredicate;

@RequiredArgsConstructor
@Component
public class AuthenticateUserUsecaseFactory implements IAuthenticateUserUsecaseFactory {

    private final IQueryUserDatasource queryUserDatasource;

    @Override
    public IAuthenticateUserUsecase create(BiPredicate<String, String> compareFunctions) {
        var queryUserRepository = new QueryUserRepository(queryUserDatasource);
        return new AuthenticateUserUsecase(compareFunctions, queryUserRepository);
    }
}
