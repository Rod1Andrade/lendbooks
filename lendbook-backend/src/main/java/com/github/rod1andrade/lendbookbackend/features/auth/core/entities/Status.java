package com.github.rod1andrade.lendbookbackend.features.auth.core.entities;

import com.github.rod1andrade.lendbookbackend.features.auth.core.enums.UserStatus;
import lombok.*;

import java.time.Instant;

/**
 * @author Rodrigo Andrade
 */
@RequiredArgsConstructor
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Status {

    public static final long TOKEN_LIMIT_TIME_IN_SECONDS = 1000;

    @Getter
    @Setter
    @EqualsAndHashCode.Include
    private Long id;

    @Getter
    @Setter
    @NonNull
    private String token;

    @Getter
    @Setter
    private Instant createAt = Instant.now();

    @Getter
    @Setter
    private Instant expiryTime = Instant.now().plusSeconds(Status.TOKEN_LIMIT_TIME_IN_SECONDS);

    @Getter
    @Setter
    @NonNull
    private UserStatus userStatus;
}
