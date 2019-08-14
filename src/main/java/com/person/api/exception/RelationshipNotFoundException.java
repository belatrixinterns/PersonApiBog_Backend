package com.person.api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.person.api.constant.MessageConstant;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class RelationshipNotFoundException extends Exception{
	
	private static final long serialVersionUID = 1L;

	public RelationshipNotFoundException() {
		super(MessageConstant.RELATIONSHIP_NOT_FOUND_MESSAGE);
	}
	
	public RelationshipNotFoundException(String message) {
		super(message);
    }
}
