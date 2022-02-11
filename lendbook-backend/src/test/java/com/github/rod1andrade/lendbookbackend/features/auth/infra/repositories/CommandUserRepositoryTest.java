package com.github.rod1andrade.lendbookbackend.features.auth.infra.repositories;

import com.github.rod1andrade.lendbookbackend.features.auth.core.entities.User;
import com.github.rod1andrade.lendbookbackend.features.auth.core.exceptions.CommandRepositoryException;
import com.github.rod1andrade.lendbookbackend.features.auth.core.repositories.ICommandUserRepository;
import com.github.rod1andrade.lendbookbackend.features.auth.infra.datasource.ICommandUserDatasource;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class CommandUserRepositoryTest {
    ICommandUserDatasource commandUserDatasource = Mockito.mock(ICommandUserDatasource.class);
    ICommandUserRepository commandUserRepository = new CommandUserRepository(commandUserDatasource);

    @Test
    void shouldSaveAUser() {
        commandUserRepository.save(Mockito.any());
        Mockito.verify(commandUserDatasource, Mockito.atLeastOnce()).save(Mockito.any());
    }

    @Test
    void shouldThrowACommandRepositoryExceptionWhenIsNotPossibleSaveAUser() {
        Mockito.doThrow(CommandRepositoryException.class)
                .when(commandUserDatasource)
                .save(Mockito.any());
        User user = Mockito.any();
        Assertions.assertThrows(
                CommandRepositoryException.class,
                () -> commandUserRepository.save(user)
        );
    }

}