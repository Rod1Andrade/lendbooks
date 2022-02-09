package com.github.rod1andrade.lendbookbackend.features.auth.external.factories;

import com.github.rod1andrade.lendbookbackend.features.auth.core.factories.IValidateUserUsecaseFactory;
import com.github.rod1andrade.lendbookbackend.features.auth.core.repositories.IQueryUserRepository;
import com.github.rod1andrade.lendbookbackend.features.auth.core.usecases.implementations.ValidateUserUsecase;
import com.github.rod1andrade.lendbookbackend.features.auth.core.usecases.interfaces.IValidateUserUsecase;
import com.github.rod1andrade.lendbookbackend.features.auth.infra.datasource.IQueryUserDatasource;
import com.github.rod1andrade.lendbookbackend.features.auth.infra.repositories.QueryUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ValidateUserUsecaseFactory implements IValidateUserUsecaseFactory {
    private final IQueryUserDatasource queryUserDatasource;

    @Override
    public IValidateUserUsecase create() {
        IQueryUserRepository queryUserRepository = new QueryUserRepository(queryUserDatasource);
        return new ValidateUserUsecase(queryUserRepository);
    }
}
