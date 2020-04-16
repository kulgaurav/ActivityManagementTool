package com.apt5.amtool.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ActivityIdException extends RuntimeException {

    public ActivityIdException(String message) {
        super(message);
    }
}
