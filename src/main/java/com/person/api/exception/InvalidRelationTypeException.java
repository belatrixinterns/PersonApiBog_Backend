package com.person.api.exception;

public class InvalidRelationTypeException extends Exception{

    private static final long serialVersionUID = -1L;

    public InvalidRelationTypeException(String message){
        super(message);

    }

}