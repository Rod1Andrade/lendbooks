package com.github.rod1andrade.lendbookbackend.features.mail.core.exceptions;

public class DispatchMailServiceException extends RuntimeException {
    public DispatchMailServiceException() {
        super();
    }

    public DispatchMailServiceException(String message) {
        super(message);
    }
}
