package com.github.rod1andrade.lendbookbackend.features.auth.external.datasource;

import com.github.rod1andrade.lendbookbackend.features.auth.core.entities.Status;
import com.github.rod1andrade.lendbookbackend.features.auth.core.entities.User;
import com.github.rod1andrade.lendbookbackend.features.auth.core.enums.UserStatus;
import com.github.rod1andrade.lendbookbackend.features.auth.core.valueobjects.Email;
import com.github.rod1andrade.lendbookbackend.features.auth.core.valueobjects.FullName;
import com.github.rod1andrade.lendbookbackend.features.auth.core.valueobjects.Password;
import com.github.rod1andrade.lendbookbackend.features.auth.core.valueobjects.UUID;
import com.github.rod1andrade.lendbookbackend.features.auth.external.models.StatusModel;
import com.github.rod1andrade.lendbookbackend.features.auth.external.models.UserModel;
import com.github.rod1andrade.lendbookbackend.features.auth.external.repositories.UserModelRepository;
import com.github.rod1andrade.lendbookbackend.features.auth.infra.datasource.IQueryUserDatasource;
import com.github.rod1andrade.lendbookbackend.features.auth.infra.exceptions.QueryUserDatasourceException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
@Slf4j
public class QueryUserDatasource implements IQueryUserDatasource {

    private final UserModelRepository userModelRepository;

    @Override
    public User findByEmail(Email email) throws QueryUserDatasourceException {
        Optional<UserModel> userModelOptional = Optional
                .ofNullable(userModelRepository.findByEmail(email.getValue()));

        if(userModelOptional.isEmpty()) return null;

        UserModel userModel = userModelOptional.get();
        StatusModel statusModel = userModel.getStatusModel();

        return new User(
                new UUID(userModel.getUuid().toString()),
                new FullName(userModel.getName(), userModel.getLastName()),
                new Email(userModel.getEmail()),
                new Password(userModel.getPassword()),
                new Status(
                        statusModel.getId(),
                        statusModel.getToken(),
                        statusModel.getCreateAt(),
                        statusModel.getExpiryTime(),
                        UserStatus.valueOf(statusModel.getStatus().getCode())
                )
        );
    }
}
