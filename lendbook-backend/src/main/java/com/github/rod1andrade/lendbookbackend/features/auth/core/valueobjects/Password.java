package com.github.rod1andrade.lendbookbackend.features.auth.core.valueobjects;

import lombok.*;

import java.util.function.Predicate;
import java.util.function.UnaryOperator;

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

    public void encode(UnaryOperator<String> encodeFunction) {
        setValue(encodeFunction.apply(getValue()));
    }

    public boolean check(Predicate<String> compareFunction) {
        return compareFunction.test(getValue());
    }

    @Override
    public String toString() {
        return value;
    }

}
