package com.person.api.exception;

public class EmptyInputException extends Exception{

    private static final long serialVersionUID = -1L;

    public EmptyInputException(String message){
        super(message);

    }

}