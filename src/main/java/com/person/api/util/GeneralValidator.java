package com.person.api.util;


import com.person.api.exception.MismatchTypeFieldException;

public class GeneralValidator {
	
	
	public static Integer validateId(String personId) throws MismatchTypeFieldException {
		return 	Integer.parseInt(personId);
		
	}
}
