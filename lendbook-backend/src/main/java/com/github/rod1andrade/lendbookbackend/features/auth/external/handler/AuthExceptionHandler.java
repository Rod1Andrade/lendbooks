package com.github.rod1andrade.lendbookbackend.features.auth.external.handler;

import com.github.rod1andrade.lendbookbackend.features.auth.core.exceptions.ActiveRegisteredUserByTokenException;
import com.github.rod1andrade.lendbookbackend.features.auth.infra.exceptions.CommandStatusDatasourceException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.persistence.PersistenceException;
import javax.servlet.http.HttpServletRequest;
import java.time.Instant;

@ControllerAdvice
public class AuthExceptionHandler {

    @ExceptionHandler(CommandStatusDatasourceException.class)
    public ResponseEntity<ResponseError> commandStatusDataSourceException(
            CommandStatusDatasourceException e,
            HttpServletRequest request
    ) {
        HttpStatus status = HttpStatus.BAD_REQUEST;

        return ResponseEntity
                .status(status)
                .body(new ResponseError(
                        "Something Wrong",
                        Instant.now(),
                        status,
                        e.getMessage(),
                        request.getRequestURI()
                ));
    }

    @ExceptionHandler(ActiveRegisteredUserByTokenException.class)
    public ResponseEntity<ResponseError> activeRegisteredUserByTokenException(
            ActiveRegisteredUserByTokenException e,
            HttpServletRequest request
    ) {
        HttpStatus status = HttpStatus.BAD_REQUEST;

        return ResponseEntity
                .status(status)
                .body(new ResponseError(
                        "Error in token",
                        Instant.now(),
                        status,
                        e.getMessage(),
                        request.getRequestURI()
                ));
    }

    @ExceptionHandler(PersistenceException.class)
    public ResponseEntity<ResponseError> persistanceException(
            PersistenceException e,
            HttpServletRequest request
    ) {
        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;

        return ResponseEntity
                .status(status)
                .body(new ResponseError(
                        "Internal Server Error",
                        Instant.now(),
                        status,
                        "Persistence Error",
                        request.getRequestURI()
                ));
    }
}
