package com.github.rod1andrade.lendbookbackend.features.auth.external.repositories;

import com.github.rod1andrade.lendbookbackend.features.auth.core.valueobjects.UUID;
import com.github.rod1andrade.lendbookbackend.features.auth.external.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserModelRepository extends JpaRepository<UserModel, UUID> {
}
