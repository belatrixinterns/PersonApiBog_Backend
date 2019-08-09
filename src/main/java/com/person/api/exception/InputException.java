package com.person.api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InputException extends Exception{

    private static final long serialVersionUID = -1L;

    public InputException(String message){
        super(message);

    }

}