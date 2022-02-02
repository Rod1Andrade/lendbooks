package com.github.rod1andrade.lendbookbackend.features.auth.external.factories;

import com.github.rod1andrade.lendbookbackend.features.auth.core.factories.IActiveRegisterdUserByTokenFactory;
import com.github.rod1andrade.lendbookbackend.features.auth.core.repositories.ICommandStatusRepository;
import com.github.rod1andrade.lendbookbackend.features.auth.core.usecases.implementations.ActiveRegisteredUserByTokenUsecase;
import com.github.rod1andrade.lendbookbackend.features.auth.core.usecases.interfaces.IActiveRegisteredUserByTokenUsecase;
import com.github.rod1andrade.lendbookbackend.features.auth.infra.datasource.ICommandStatusDatasource;
import com.github.rod1andrade.lendbookbackend.features.auth.infra.repositories.CommandStatusRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ActiveRegisterdUserByTokenFactory implements IActiveRegisterdUserByTokenFactory {

    private final ICommandStatusDatasource commandStatusDatasource;

    @Override
    public IActiveRegisteredUserByTokenUsecase create() {
        ICommandStatusRepository commandStatusRepository = new CommandStatusRepository(commandStatusDatasource);
        return new ActiveRegisteredUserByTokenUsecase(commandStatusRepository);
    }
}
