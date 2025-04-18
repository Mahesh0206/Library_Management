package com.example.library.exception;

import com.example.library.util.ResponseData;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ResponseData> handleResourceNotFound(ResourceNotFoundException ex) {
        return new ResponseEntity<>(ResponseData.builder().statusCode(HttpStatus.NOT_FOUND.value())
                .statusMessage(ex.getMessage()).build(), HttpStatus.OK);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ResponseData> handleGeneric(Exception ex) {
        return new ResponseEntity<>(ResponseData.builder().statusCode(HttpStatus.BAD_REQUEST.value())
                .statusMessage(ex.getMessage()).build(), HttpStatus.OK);
    }
}
