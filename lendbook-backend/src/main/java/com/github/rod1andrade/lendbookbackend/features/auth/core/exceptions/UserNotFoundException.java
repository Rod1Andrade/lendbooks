package com.github.rod1andrade.lendbookbackend.features.auth.core.exceptions;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException() {}

    public UserNotFoundException(String s) {
        super(s);
    }
}
