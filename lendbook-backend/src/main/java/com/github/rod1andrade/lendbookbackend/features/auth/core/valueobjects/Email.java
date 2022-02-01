package com.github.rod1andrade.lendbookbackend.features.auth.core.valueobjects;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.function.Function;

/**
 * @author Rodrigo Andrade
 */
@NoArgsConstructor
@AllArgsConstructor
public class Email {
    @Getter
    @Setter
    private String value;

    public boolean isValidEmail(Function<String, Boolean> validEmailFunction) {
        return validEmailFunction.apply(getValue());
    }

    @Override
    public String toString() {
        return value;
    }
}
