package com.person.api.exception;

import com.person.api.constant.MessageConstant;

public class DefaultException extends Exception{
	
	private static final long serialVersionUID = 1L;

	public DefaultException() {
		super(MessageConstant.DEFAULT_MESSAGE);
	}

}
