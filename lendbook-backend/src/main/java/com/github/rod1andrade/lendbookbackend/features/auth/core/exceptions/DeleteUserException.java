package com.github.rod1andrade.lendbookbackend.features.auth.core.exceptions;

public class DeleteUserException extends RuntimeException {
    public DeleteUserException() {
        super();
    }

    public DeleteUserException(String message) {
        super(message);
    }
}
