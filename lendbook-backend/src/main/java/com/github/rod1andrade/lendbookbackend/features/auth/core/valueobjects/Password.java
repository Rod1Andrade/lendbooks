package com.github.rod1andrade.lendbookbackend.features.auth.core.valueobjects;

import lombok.*;

import java.util.function.Function;

/**
 * @author Rodrigo Andrade
 */
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Password {

    @Getter
    @Setter
    @EqualsAndHashCode.Include
    private String value;

    public void encode(Function<String, String> encodeFunction) {
        setValue(encodeFunction.apply(getValue()));
    }

    public boolean check(Function<String, Boolean> compareFunction) {
        return compareFunction.apply(getValue());
    }

    @Override
    public String toString() {
        return value;
    }

}
