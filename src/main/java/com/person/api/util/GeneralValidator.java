package com.person.api.util;


import com.person.api.constant.MessageConstant;
import com.person.api.constant.document.DocumentType;
import com.person.api.constant.document.DocumentTypeCC;
import com.person.api.exception.MismatchTypeFieldException;


public class GeneralValidator {
	
	private GeneralValidator() {
	}
	
	public static Integer validateId(String personId) throws MismatchTypeFieldException {
		Integer objectId = null;
		
		try {
			objectId = Integer.parseInt(personId);
		}catch (Exception e) {
			throw new MismatchTypeFieldException(MessageConstant.MISMATCH_TYPE_FIELD_MESSAGE+", please verify that your identifier be a number");
		}
		
		return objectId;
	}

	
}
