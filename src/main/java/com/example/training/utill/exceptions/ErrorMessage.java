package com.example.training.utill.exceptions;


import java.util.Date;

public class ErrorMessage {

    private final int statusCode;

    private final Date timestamp;

    private final String error;

    public ErrorMessage(int statusCode, Date timestamp, String error) {
        this.statusCode = statusCode;
        this.timestamp = timestamp;
        this.error = error;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public String getError() {
        return error;
    }
}
