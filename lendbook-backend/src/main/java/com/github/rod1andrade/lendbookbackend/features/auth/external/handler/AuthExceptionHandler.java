package com.github.rod1andrade.lendbookbackend.features.auth.external.handler;

import com.github.rod1andrade.lendbookbackend.features.auth.core.exceptions.*;
import com.github.rod1andrade.lendbookbackend.features.auth.infra.exceptions.CommandStatusDatasourceException;
import org.hibernate.exception.ConstraintViolationException;
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

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ResponseError> constraintViolationException(
            ConstraintViolationException e,
            HttpServletRequest request
    ) {
        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;

        return ResponseEntity
                .status(status)
                .body(new ResponseError(
                        "Internal Server Error",
                        Instant.now(),
                        status,
                        "Constraint Violation",
                        request.getRequestURI()
                ));
    }

    @ExceptionHandler(RegisterUserExcepion.class)
    public ResponseEntity<ResponseError> registerUserExcepion(
            RegisterUserExcepion e,
            HttpServletRequest request
    ) {
        HttpStatus status = HttpStatus.BAD_REQUEST;

        return ResponseEntity
                .status(status)
                .body(new ResponseError(
                        "Bad Request.",
                        Instant.now(),
                        status,
                        e.getMessage(),
                        request.getRequestURI()
                ));
    }

    @ExceptionHandler(InvalidUserExcepetion.class)
    public ResponseEntity<ResponseError> invalidUserExcepetion(
            InvalidUserExcepetion e,
            HttpServletRequest request
    ) {
        HttpStatus status = HttpStatus.BAD_REQUEST;

        return ResponseEntity
                .status(status)
                .body(new ResponseError(
                        "Bad Request with user informations.",
                        Instant.now(),
                        status,
                        e.getMessage(),
                        request.getRequestURI()
                ));
    }

    //ImpossibleSendMailException
    @ExceptionHandler(ImpossibleSendMailException.class)
    public ResponseEntity<ResponseError> impossibleSendMailException(
            ImpossibleSendMailException e,
            HttpServletRequest request
    ) {
        HttpStatus status = HttpStatus.SERVICE_UNAVAILABLE;

        return ResponseEntity
                .status(status)
                .body(new ResponseError(
                        "Email service unavaliable.",
                        Instant.now(),
                        status,
                        e.getMessage(),
                        request.getRequestURI()
                ));
    }

    @ExceptionHandler(UserNotActiveException.class)
    public ResponseEntity<ResponseError> userNotActiveException(
            UserNotActiveException e,
            HttpServletRequest request
    ) {
        HttpStatus status = HttpStatus.FORBIDDEN;

        return ResponseEntity
                .status(status)
                .body(new ResponseError(
                        "User account has troubles.",
                        Instant.now(),
                        status,
                        e.getMessage(),
                        request.getRequestURI()
                ));
    }

    @ExceptionHandler(UserCredentialException.class)
    public ResponseEntity<ResponseError> userCredentialException(
            UserCredentialException e,
            HttpServletRequest request
    ) {
        HttpStatus status = HttpStatus.UNAUTHORIZED;

        return ResponseEntity
                .status(status)
                .body(new ResponseError(
                        "User credentials is not valid",
                        Instant.now(),
                        status,
                        e.getMessage(),
                        request.getRequestURI()
                ));
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ResponseError> userNotFoundException(
            UserNotFoundException e,
            HttpServletRequest request
    ) {
        HttpStatus status = HttpStatus.NOT_FOUND;

        return ResponseEntity
                .status(status)
                .body(new ResponseError(
                        "User credentials is not valid",
                        Instant.now(),
                        status,
                        e.getMessage(),
                        request.getRequestURI()
                ));
    }
}
