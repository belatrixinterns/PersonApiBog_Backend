package com.person.api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.person.api.constant.MessageConstant;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class UserHasAlreadyExistException extends Exception{
	
	private static final long serialVersionUID = 1L;

	public UserHasAlreadyExistException() {
		super(MessageConstant.USER_HAS_ALREADY_EXIST);
	}

}
