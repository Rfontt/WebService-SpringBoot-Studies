package com.rest.webservice.controller;

import com.rest.webservice.bean.ExceptionResponseBean;
import com.rest.webservice.exceptions.UserNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@ControllerAdvice
@RestController
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(Exception.class)
    public final ResponseEntity<Object> handleAllException(Exception ex, WebRequest request) {
        ExceptionResponseBean exceptionResponseBean = new ExceptionResponseBean(new Date(), ex.getMessage(), request.getDescription(false));

        return new ResponseEntity(exceptionResponseBean, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(UserNotFoundException.class)
    public final ResponseEntity<Object> handleUserNotFoundException(UserNotFoundException ex, WebRequest request) {
        ExceptionResponseBean exceptionResponseBean = new ExceptionResponseBean(new Date(), ex.getMessage(), request.getDescription(false));

        return new ResponseEntity(exceptionResponseBean, HttpStatus.NOT_FOUND);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        ExceptionResponseBean exceptionResponseBean = new ExceptionResponseBean(new Date(), ex.getMessage(), "Validation failed");

        return new ResponseEntity(exceptionResponseBean, HttpStatus.BAD_REQUEST);
    }
}
