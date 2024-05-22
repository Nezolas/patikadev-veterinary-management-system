package com.veterinarymanagementsystem.core.exception;

public class DataExistsException extends RuntimeException {
    public DataExistsException(String message){
        super(message);
    }
}
