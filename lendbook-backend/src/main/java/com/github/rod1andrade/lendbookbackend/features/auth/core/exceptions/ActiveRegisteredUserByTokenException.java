package com.github.rod1andrade.lendbookbackend.features.auth.core.exceptions;

public class ActiveRegisteredUserByTokenException extends RuntimeException {
    public ActiveRegisteredUserByTokenException() {
        super();
    }

    public ActiveRegisteredUserByTokenException(String message) {
        super(message);
    }
}
