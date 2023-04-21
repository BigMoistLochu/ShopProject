package com.example.projektpowtorzeniowy.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ProduktNotFoundAdvice {

    @ResponseBody
    @ExceptionHandler(ProduktNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String getException(ProduktNotFoundException ex)
    {
        return ex.getMessage();
    }
}
