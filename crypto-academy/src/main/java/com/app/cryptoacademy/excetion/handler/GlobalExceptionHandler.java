package com.app.cryptoacademy.excetion.handler;

import com.app.cryptoacademy.excetion.EmptyInputException;
import com.app.cryptoacademy.excetion.NonExistingEntityException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(EmptyInputException.class)
    public ResponseEntity<String> handleEmptyInput(EmptyInputException ex){
        return new ResponseEntity<String>("Input field cannot be empty", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NonExistingEntityException.class)
    public ResponseEntity<String> handleNonExistingInput(NonExistingEntityException ex){
        return new ResponseEntity<String>("The value do not present in our system", HttpStatus.BAD_REQUEST);
    }
}
