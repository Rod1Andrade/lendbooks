package com.github.rod1andrade.lendbookbackend.features.auth.external.repositories;

import com.github.rod1andrade.lendbookbackend.features.auth.external.models.StatusModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatusModelRepository extends JpaRepository<StatusModel, Long> {
    StatusModel findByToken(String token);
}
