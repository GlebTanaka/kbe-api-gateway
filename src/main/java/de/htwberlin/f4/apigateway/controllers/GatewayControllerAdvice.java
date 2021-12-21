package de.htwberlin.f4.apigateway.controllers;

import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GatewayControllerAdvice {
     /**
     * händelt ConstraintViolationException
     * @param e ConstraintViolationException
     * @return ResponseEntity mit Validierungsfehlermeldung
     */
    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    private ResponseEntity<String> handleConstraintViolationException(ConstraintViolationException e) {
        return new ResponseEntity<>("Validation Error: " + e.getMessage(), HttpStatus.BAD_REQUEST);
    }

    /**
     * händelt NumberFormatException
     * @param e NumberFormatException
     * @return ResponseEntity mit fehlermeldung
     */
    @ExceptionHandler(NumberFormatException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    private ResponseEntity<String> handleNumberFormatException(NumberFormatException e) {
        return new ResponseEntity<>("NumberFormatException: " + e.getMessage(), HttpStatus.BAD_REQUEST);
    }

    /**
     * händelt IllegalArgumentException
     * @param e IllegalArgumentException
     * @return ResponseEntity mit fehlermeldung
     */
    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    private ResponseEntity<String> handleIllegalArgumentException(IllegalArgumentException e) {
        return new ResponseEntity<>("IllegalArgumentException: " + e.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
