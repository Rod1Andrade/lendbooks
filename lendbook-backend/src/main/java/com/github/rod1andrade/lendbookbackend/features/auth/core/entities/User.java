package com.github.rod1andrade.lendbookbackend.features.auth.core.entities;

import com.github.rod1andrade.lendbookbackend.features.auth.core.valueobjects.Email;
import com.github.rod1andrade.lendbookbackend.features.auth.core.valueobjects.FullName;
import com.github.rod1andrade.lendbookbackend.features.auth.core.valueobjects.Password;
import com.github.rod1andrade.lendbookbackend.features.auth.core.valueobjects.UUID;
import lombok.*;

/**
 * @author Rodrigo Andrade
 */
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class User {

    @Getter
    @Setter
    @EqualsAndHashCode.Include
    private UUID uuid;

    @Getter
    @Setter
    @NonNull
    private FullName fullName;

    @Getter
    @Setter
    @NonNull
    private Email email;

    @Getter
    @Setter
    @NonNull
    private Password password;

    @Getter
    @Setter
    private Status status;

}
