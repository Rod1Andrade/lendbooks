package com.github.rod1andrade.lendbookbackend.features.auth.core.valueobjects;

import java.util.function.BiPredicate;
import java.util.function.Function;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Rodrigo Andrade
 */
@NoArgsConstructor
@AllArgsConstructor
public class Password {

    @Getter
    @Setter
    private String value;

    public void encode(Function<String, String> encodeFunction) {
        setValue(encodeFunction.apply(getValue()));
    }

    @Override
    public String toString() {
        return value;
    }

	public boolean check(Password password, BiPredicate<String, String> compareFunctions) {
		return compareFunctions.test(password.getValue(), this.value);
	}

}
