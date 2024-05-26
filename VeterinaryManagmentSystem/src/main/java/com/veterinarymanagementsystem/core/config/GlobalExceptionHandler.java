package com.veterinarymanagementsystem.core.config;

import com.veterinarymanagementsystem.core.exception.DataExistsException;
import com.veterinarymanagementsystem.core.exception.NotFoundException;
import com.veterinarymanagementsystem.core.result.Result;
import com.veterinarymanagementsystem.core.utilities.ResultHelper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    // NotFoundException türündeki istisnaları işleyen metot
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<Result> handleNotFoundException(NotFoundException e){
        return new ResponseEntity<>(ResultHelper.notFoundError(e.getMessage()), HttpStatus.NOT_FOUND);
    }
    // DataExistsException türündeki istisnaları işleyen metot    @ExceptionHandler(DataExistsException.class)
    public ResponseEntity<Result> handleDataExistsException(DataExistsException e){
        return new ResponseEntity<>(ResultHelper.dataAlreadyExistError(e.getMessage()), HttpStatus.BAD_REQUEST);
    }
}
