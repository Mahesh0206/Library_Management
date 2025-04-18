package com.example.library.util;

import org.hibernate.annotations.Comment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CommonApiResponse {
    public ResponseEntity<ResponseData> errorResponse(Errors result) {
        List<ErrorData> errors = result.getFieldErrors().stream()
                .map(field -> new ErrorData(field.getField(), field.getDefaultMessage())).collect(Collectors.toList());
        return new ResponseEntity<>(ResponseData.builder().statusCode(HttpStatus.BAD_REQUEST.value())
                .statusMessage("Required mandatory fields").errors(errors).build(), HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<ResponseData> successResponse(Object object) {
        return new ResponseEntity<>(ResponseData.builder().statusCode(200)
                .statusMessage("Sucess").data(object).build(), HttpStatus.OK);
    }
}
