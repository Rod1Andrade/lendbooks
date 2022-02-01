package com.github.rod1andrade.lendbookbackend.features.auth.external.factories;

import com.github.rod1andrade.lendbookbackend.features.auth.core.repositories.ICommandUserRepository;
import com.github.rod1andrade.lendbookbackend.features.auth.core.usecases.implementations.RegisterUserUsecase;
import com.github.rod1andrade.lendbookbackend.features.auth.core.usecases.interfaces.IRegisterUserUsecase;
import com.github.rod1andrade.lendbookbackend.features.auth.infra.datasource.ICommandUserDatasource;
import com.github.rod1andrade.lendbookbackend.features.auth.infra.repositories.CommandUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RegisterUserUsecaseFactory {

    private final ICommandUserDatasource commandUserDatasource;

    public IRegisterUserUsecase create() {
        ICommandUserRepository commandUserRepository = new CommandUserRepository(commandUserDatasource);
        return new RegisterUserUsecase(commandUserRepository);
    }

}
