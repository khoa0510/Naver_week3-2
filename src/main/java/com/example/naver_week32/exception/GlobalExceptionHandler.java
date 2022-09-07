package com.example.naver_week32.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler({ RuntimeException.class })
    public ResponseEntity<String> handleExceptionA(Exception e) {
        return ResponseEntity.status(400).body("Bad Request");
    }
}

