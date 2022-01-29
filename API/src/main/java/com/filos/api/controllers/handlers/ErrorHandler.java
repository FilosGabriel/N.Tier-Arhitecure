package com.filos.api.controllers.handlers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@Slf4j
@ControllerAdvice
public class ErrorHandler {

    @ExceptionHandler(IllegalAccessException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public void processValidationError(IllegalAccessException exception) {
        log.info("Returning HTTP 400 Bad Request", exception);
    }
}
