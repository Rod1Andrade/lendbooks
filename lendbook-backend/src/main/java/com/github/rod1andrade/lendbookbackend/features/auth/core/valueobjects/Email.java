package com.github.rod1andrade.lendbookbackend.features.auth.core.valueobjects;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.function.Predicate;

/**
 * @author Rodrigo Andrade
 */
@NoArgsConstructor
@AllArgsConstructor
public class Email {
    @Getter
    @Setter
    private String value;

    public boolean isValidEmail(Predicate<String> validEmailFunction) {
        return validEmailFunction.test(getValue());
    }

    @Override
    public String toString() {
        return value;
    }
}
