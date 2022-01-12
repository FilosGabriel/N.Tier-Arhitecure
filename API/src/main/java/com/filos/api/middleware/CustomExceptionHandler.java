package com.filos.api.middleware;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.time.Clock;
import java.time.LocalDateTime;

@Slf4j
@ControllerAdvice
@RequiredArgsConstructor
public class CustomExceptionHandler {
    private final Clock clock = Clock.systemUTC();


    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(RuntimeException.class)
    public ResponseException handleException(RuntimeException exception) {
        log.info("Fail to process request. Cause of the fail is {}", exception.getCause());
        return new ResponseException(exception.getMessage(), LocalDateTime.now(clock));
    }

    public record ResponseException(String message, LocalDateTime dateTime) {
    }
}
