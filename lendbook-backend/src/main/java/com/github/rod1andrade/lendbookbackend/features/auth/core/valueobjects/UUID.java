package com.github.rod1andrade.lendbookbackend.features.auth.core.valueobjects;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.function.Supplier;

/**
 * @author Rodrigo Andrade
 */
@NoArgsConstructor
@AllArgsConstructor
public class UUID {

    @Getter
    @Setter
    private String value;

    public void randomUuid(Supplier<String> supplier) {
        setValue(supplier.get());
    }

    @Override
    public String toString() {
        return value;
    }

}
