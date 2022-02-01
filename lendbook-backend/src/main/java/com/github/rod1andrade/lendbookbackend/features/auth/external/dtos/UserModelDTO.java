package com.github.rod1andrade.lendbookbackend.features.auth.external.dtos;

import com.github.rod1andrade.lendbookbackend.features.auth.core.entities.Status;
import com.github.rod1andrade.lendbookbackend.features.auth.core.entities.User;
import com.github.rod1andrade.lendbookbackend.features.auth.core.enums.UserStatus;
import com.github.rod1andrade.lendbookbackend.features.auth.core.valueobjects.Email;
import com.github.rod1andrade.lendbookbackend.features.auth.core.valueobjects.FullName;
import com.github.rod1andrade.lendbookbackend.features.auth.core.valueobjects.Password;
import com.github.rod1andrade.lendbookbackend.features.auth.external.models.UserModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
public class UserModelDTO {

    @Getter
    @Setter
    private String name;

    @Getter
    @Setter
    private String lastName;

    @Getter
    @Setter
    private String email;

    @Getter
    @Setter
    private String password;

    public static UserModel castUserToUserModel(User user) {
        var userModel = new UserModel(
                user.getFullName().getFirstName(),
                user.getFullName().getLastName(),
                user.getEmail().getValue(),
                user.getPassword().getValue()
        );

        userModel.setStatusModel(StatusModelDTO.castStatusToStatusModel(user.getStatus()));

        return userModel;
    }

    public static User castUserMOdelDTOToUser(UserModelDTO userModelDTO, PasswordEncoder passwordEncoder) {
        var password = new Password(userModelDTO.getPassword());
        password.encode(passwordEncoder::encode);
        var user = new User(
                new FullName(userModelDTO.getName(), userModelDTO.getLastName()),
                new Email(userModelDTO.getEmail()),
                password
        );

        user.setStatus(new Status(UUID.randomUUID().toString(), UserStatus.UNACTIVATE));

        return user;
    }
}
