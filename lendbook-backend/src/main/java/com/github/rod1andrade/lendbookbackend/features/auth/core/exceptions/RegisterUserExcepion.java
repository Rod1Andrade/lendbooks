package com.github.rod1andrade.lendbookbackend.features.auth.core.exceptions;

public class RegisterUserExcepion extends RuntimeException {
    public RegisterUserExcepion() {
        super();
    }

    public RegisterUserExcepion(String message) {
        super(message);
    }
}
