package com.blizzard.bookstore.common;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
public class BindExceptionHandler {
    @ExceptionHandler(BindException.class)
    public ResponseEntity handle(BindException e) {
        List<String> errorList = e.getFieldErrors().stream().map(FieldError::getDefaultMessage).toList();
        return new ResponseEntity(errorList, HttpStatus.BAD_REQUEST);
    }
}
