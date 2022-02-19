package com.github.rod1andrade.lendbookbackend.features.auth.external.repositories;

import com.github.rod1andrade.lendbookbackend.features.auth.core.valueobjects.UUID;
import com.github.rod1andrade.lendbookbackend.features.auth.external.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserModelRepository extends JpaRepository<UserModel, UUID> {
    UserModel findByEmail(String email);
    
    Boolean existsByEmail(String email);

    Optional<UserModel> findByUuid(java.util.UUID fromString);
}
