package com.github.rod1andrade.lendbookbackend.features.auth.infra.exceptions;

/**
 * @author Rodrigo Andrade
 */
public class CommandStatusDatasourceException extends RuntimeException {
    public CommandStatusDatasourceException() {
        super();
    }

    public CommandStatusDatasourceException(String message) {
        super(message);
    }
}
