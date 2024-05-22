package com.veterinarymanagementsystem.core.result;

import lombok.Getter;

@Getter
public class Result {
    private final boolean status;
    private final String message;
    private final String httpCode;

    public Result(boolean status, String message, String httpCode) {
        this.status = status;
        this.message = message;
        this.httpCode = httpCode;
    }
}
