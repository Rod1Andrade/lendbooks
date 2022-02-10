package com.github.rod1andrade.lendbookbackend.features.auth.core.exceptions;

public class ImpossibleSendMailException extends RuntimeException {
    public ImpossibleSendMailException() {
        super();
    }

    public ImpossibleSendMailException(String message) {
        super(message);
    }
}
