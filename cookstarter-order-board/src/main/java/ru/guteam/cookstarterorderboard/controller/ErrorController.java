package ru.guteam.cookstarterorderboard.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

@Slf4j
@ControllerAdvice
public class ErrorController {

    @ExceptionHandler
    public ResponseEntity<String> exception(Exception e) {
        log.error("Unknown error", e);
        return new ResponseEntity(e.getMessage(), INTERNAL_SERVER_ERROR);
    }
}
