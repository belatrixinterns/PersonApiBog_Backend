package com.person.api.exception;

import com.person.api.constant.MessageConstant;

public class UserNotFoundException extends Exception{
	
	private static final long serialVersionUID = 1L;

	public UserNotFoundException() {
		super(MessageConstant.USER_NOT_FOUND_MESSAGE);
	}

}
