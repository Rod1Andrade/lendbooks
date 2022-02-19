package com.github.rod1andrade.lendbookbackend.services;

import com.github.rod1andrade.lendbookbackend.features.auth.core.exceptions.UserNotFoundException;
import com.github.rod1andrade.lendbookbackend.features.auth.external.models.UserModel;
import com.github.rod1andrade.lendbookbackend.features.auth.external.repositories.UserModelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserDetailServiceImpl implements UserDetailsService {

    private final UserModelRepository userModelRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        throw new IllegalArgumentException("Is not used for load user");
    }

    public UserDetails loadUserByUUID(String uuid) {
        Optional<UserModel> userModelOptional = userModelRepository.findByUuid(UUID.fromString(uuid));
        var user = userModelOptional.orElseThrow(UserNotFoundException::new);
        return new User(user.getEmail(), user.getPassword(), new ArrayList<>());
    }
}
