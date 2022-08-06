package com.example.training.utill.exceptions;

import  org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class ExceptionHandlerAdvice {


    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<?> notFoundException(NotFoundException e) {
        return new ResponseEntity<>(createMessage(e, HttpStatus.NOT_FOUND), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<?> badRequestException(BadRequestException e) {
        return new ResponseEntity<>(createMessage(e, HttpStatus.BAD_REQUEST), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(DuplicateDataException.class)
    public ResponseEntity<?> badRequestException(DuplicateDataException e) {
        return new ResponseEntity<>(createMessage(e, HttpStatus.CONFLICT), HttpStatus.CONFLICT);
    }

    private ErrorMessage createMessage(Throwable e, HttpStatus status) {
        return new ErrorMessage(
                status.value(),
                new Date(),
                e.getMessage());
    }
}
