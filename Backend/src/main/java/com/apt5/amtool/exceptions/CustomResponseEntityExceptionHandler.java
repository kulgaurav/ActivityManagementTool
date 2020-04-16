package com.apt5.amtool.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class CustomResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler
    public final ResponseEntity<Object> handleProjectIdException(ActivityIdException e, WebRequest request){
        ActivityIdExceptionResponse activityIdExceptionResponse = new ActivityIdExceptionResponse(e.getMessage());
        return new ResponseEntity<Object>(activityIdExceptionResponse, HttpStatus.BAD_REQUEST);
    }
}
