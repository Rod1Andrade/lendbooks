package com.github.rod1andrade.lendbookbackend.features.auth.core.usecases.implementations;

import com.github.rod1andrade.lendbookbackend.features.auth.core.exceptions.CommandRepositoryException;
import com.github.rod1andrade.lendbookbackend.features.auth.core.exceptions.DeleteUserException;
import com.github.rod1andrade.lendbookbackend.features.auth.core.ports.AbstractUserInputData;
import com.github.rod1andrade.lendbookbackend.features.auth.core.repositories.ICommandUserRepository;
import com.github.rod1andrade.lendbookbackend.features.auth.core.usecases.interfaces.IDeleteUserUsecase;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class DeleteUserUsecase implements IDeleteUserUsecase {

    private final ICommandUserRepository commandUserRepository;

    @Override
    public void apply(AbstractUserInputData userInputData) throws DeleteUserException {
        try {
            commandUserRepository.delete(userInputData.parserToEntity(null));
        } catch (CommandRepositoryException e) {
            throw new DeleteUserException(e.getMessage());
        } catch (Exception e) {
            throw new DeleteUserException("Erro inesperado ao deletar usuário.");
        }
    }
}
