package ru.guteam.restaurantservice.controller;


import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import io.jsonwebtoken.JwtException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestHeader;
import ru.guteam.restaurantservice.exception.NotFountException;

import java.net.ConnectException;
import java.nio.charset.MalformedInputException;

import static org.springframework.http.HttpStatus.*;
import static ru.guteam.restaurantservice.controller.util.ResponseBuilder.error;
import static ru.guteam.restaurantservice.util.RequestHeaders.JWT_HEADER;

@Slf4j
@ControllerAdvice
public class ErrorController {


    @ExceptionHandler({InvalidFormatException.class,
            MethodArgumentNotValidException.class,
            MalformedInputException.class})
    public ResponseEntity invalidFormat(Exception e) {
        String message = "Bad request";
        log.error(message, e);
        return error(message, BAD_REQUEST);
    }

    @ExceptionHandler(ConnectException.class)
    public ResponseEntity connectionLost(Exception e) {
        String message = "Service is unavailable";
        log.error(message, e);
        return error(message, INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(JwtException.class)
    public ResponseEntity jwtError(@RequestHeader(JWT_HEADER) String token, Exception e) {
        String message = "Error checking the token";
        log.error(message + " : " + token, e);
        return error(message, BAD_REQUEST);
    }

    @ExceptionHandler(NotFountException.class)
    public ResponseEntity notFound(Exception e) {
        log.error(e.getMessage(), e);
        return error(e.getMessage(), NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity exception(Exception e) {
        log.error("Unknown error", e);
        return error(INTERNAL_SERVER_ERROR);
    }


}
