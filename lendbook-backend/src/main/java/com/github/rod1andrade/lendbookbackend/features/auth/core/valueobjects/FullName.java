package com.github.rod1andrade.lendbookbackend.features.auth.core.valueobjects;

import lombok.*;

/**
 * @author Rodrigo Andrade
 */
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@AllArgsConstructor
public class FullName {
    @Getter
    @Setter
    @EqualsAndHashCode.Include
    private String firstName;

    @Getter
    @Setter
    @EqualsAndHashCode.Include
    private String lastName;

    @Override
    public String toString() {
        return firstName + " " + lastName;
    }
}
