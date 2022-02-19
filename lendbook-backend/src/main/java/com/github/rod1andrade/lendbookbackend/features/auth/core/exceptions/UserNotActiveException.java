package com.github.rod1andrade.lendbookbackend.features.auth.core.exceptions;

public class UserNotActiveException extends RuntimeException {
    public UserNotActiveException(String s) {
        super(s);
    }
}
