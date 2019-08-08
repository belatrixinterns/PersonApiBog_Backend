package com.person.api.exceptions;

public class EmptyInputException extends Exception{

    private static final long serialVersionUID = -1L;

    public EmptyInputException(String message){
        super(message);

    }

}