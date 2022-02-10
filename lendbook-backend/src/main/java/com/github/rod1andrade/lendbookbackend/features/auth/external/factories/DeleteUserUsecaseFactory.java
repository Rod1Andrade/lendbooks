package com.github.rod1andrade.lendbookbackend.features.auth.external.factories;

import com.github.rod1andrade.lendbookbackend.features.auth.core.factories.IDeleteUserUsecaseFactory;
import com.github.rod1andrade.lendbookbackend.features.auth.core.repositories.ICommandUserRepository;
import com.github.rod1andrade.lendbookbackend.features.auth.core.usecases.implementations.DeleteUserUsecase;
import com.github.rod1andrade.lendbookbackend.features.auth.core.usecases.interfaces.IDeleteUserUsecase;
import com.github.rod1andrade.lendbookbackend.features.auth.infra.datasource.ICommandUserDatasource;
import com.github.rod1andrade.lendbookbackend.features.auth.infra.repositories.CommandUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DeleteUserUsecaseFactory implements IDeleteUserUsecaseFactory {
    private final ICommandUserDatasource commandUserDatasource;

    @Override
    public IDeleteUserUsecase create() {
        ICommandUserRepository commandUserRepository = new CommandUserRepository(commandUserDatasource);
        return new DeleteUserUsecase(commandUserRepository);
    }
}
