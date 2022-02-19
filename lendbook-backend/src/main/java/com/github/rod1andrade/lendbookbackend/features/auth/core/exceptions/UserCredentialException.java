package com.github.rod1andrade.lendbookbackend.features.auth.core.exceptions;

public class UserCredentialException extends RuntimeException {
    public UserCredentialException(String msg) {
        super(msg);
    }
}
