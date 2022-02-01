package com.github.rod1andrade.lendbookbackend.features.auth.core.entities;

import com.github.rod1andrade.lendbookbackend.features.auth.core.enums.UserStatus;
import lombok.*;

/**
 * @author Rodrigo Andrade
 */
@RequiredArgsConstructor
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Status {
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
    @NonNull
    private UserStatus userStatus;
}
