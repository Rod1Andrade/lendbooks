package com.github.rod1andrade.lendbookbackend.features.mail.core.exceptions;

public class DispatchMailException extends RuntimeException {
    public DispatchMailException() {
        super();
    }

    public DispatchMailException(String message) {
        super(message);
    }
}
