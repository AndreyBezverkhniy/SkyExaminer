package pro.sky.java.examinerservice.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import pro.sky.java.examinerservice.exception.UnavailableAmountRequestException;

@ControllerAdvice
public class ControllerExceptionHandler {
    @ExceptionHandler(UnavailableAmountRequestException.class)
    public ResponseEntity<String> handleException(UnavailableAmountRequestException e) {
        return ResponseEntity.badRequest().body("Amount can be only from 1 to actual amount of questions");
    }
}
