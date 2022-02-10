package com.github.rod1andrade.lendbookbackend.features.auth.external.datasource;

import com.github.rod1andrade.lendbookbackend.features.auth.core.entities.User;
import com.github.rod1andrade.lendbookbackend.features.auth.external.models.StatusModel;
import com.github.rod1andrade.lendbookbackend.features.auth.external.models.UserModel;
import com.github.rod1andrade.lendbookbackend.features.auth.external.repositories.UserModelRepository;
import com.github.rod1andrade.lendbookbackend.features.auth.infra.datasource.ICommandUserDatasource;
import com.github.rod1andrade.lendbookbackend.features.auth.infra.exceptions.CommandUserDatasourceException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
@Slf4j
public class CommandUserDatasource implements ICommandUserDatasource {

    private final UserModelRepository userModelRepository;

    @Override
    public void save(User user) throws CommandUserDatasourceException {
        try {
            userModelRepository.save(
                    UserModel.builder()
                            .name(user.getFullName().getFirstName())
                            .lastName(user.getFullName().getLastName())
                            .email(user.getEmail().getValue())
                            .password(user.getPassword().getValue())
                            .statusModel(
                                    StatusModel.builder()
                                            .createAt(user.getStatus().getCreateAt())
                                            .expiryTime(user.getStatus().getExpiryTime())
                                            .token(user.getStatus().getToken())
                                            .build())
                            .build()
            );
        } catch (DataIntegrityViolationException e) {
            throw new CommandUserDatasourceException("Email ja cadastrado!");
        }
    }

    @Override
    public void delete(User user) throws CommandUserDatasourceException {
        try {
            userModelRepository.delete(userModelRepository.findByEmail(user.getEmail().getValue()));
        } catch (Exception e) {
            throw new CommandUserDatasourceException("Erro ao tentar deletar usuario");
        }
    }
}
