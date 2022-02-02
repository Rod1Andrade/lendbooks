package com.github.rod1andrade.lendbookbackend.features.auth.external.handler;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.time.Instant;

@AllArgsConstructor
@NoArgsConstructor
public class ResponseError {

    @Getter
    @Setter
    private String error;

    @Getter
    @Setter
    private Instant timestamp;

    @Getter
    @Setter
    private HttpStatus status;

    @Getter
    @Setter
    private String message;

    @Getter
    @Setter
    private String path;

}
