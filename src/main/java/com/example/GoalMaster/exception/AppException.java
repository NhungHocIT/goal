package com.example.GoalMaster.exception;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AppException extends Exception{
    private final int statusCode;

    public AppException(String message, int statusCode) {
        super(message);
        this.statusCode = statusCode;
    }
}