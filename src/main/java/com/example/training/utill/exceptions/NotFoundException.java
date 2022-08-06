package com.example.training.utill.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(HttpStatus.BAD_REQUEST)
public class NotFoundException extends Exception {

    public NotFoundException() {

    }

    public NotFoundException(String message) {
        super(message);
    }
}
