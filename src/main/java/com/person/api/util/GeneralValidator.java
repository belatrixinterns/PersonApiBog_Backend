package com.person.api.util;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.person.api.constant.MessageConstant;
import com.person.api.constant.document.DocumentTypeFactory;
import com.person.api.exception.InputException;
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

	public static boolean validationOfName(String name, String lastName) throws InputException{
		if(name == null || name.length() == 0){
			throw new InputException(MessageConstant.INVALID_NAME_NOT_NULL);
		}
		if(lastName == null || lastName.length() == 0){
			throw new InputException(MessageConstant.INVALID_LAST_NAME_NOT_NULL);
		}
		if(name.length() > 25){
			throw new InputException(MessageConstant.INVALID_NAME_LENGTH);
		}
		if(lastName.length() > 25){
			throw new InputException(MessageConstant.INVALID_LAST_NAME_LENGTH);
		}
		Pattern p = Pattern.compile("[^a-z0-9 ]", Pattern.CASE_INSENSITIVE);
		Matcher m = p.matcher(name);
		if (m.find()){
			throw new InputException(MessageConstant.INVALID_NAME_FORMAT);
		}
		m = p.matcher(lastName);
		if (m.find()){
			throw new InputException(MessageConstant.INVALID_LAST_NAME_FORMAT);
		}
		return true;
	}

	public static boolean validationOfNacionality(String nacionality) throws InputException{
		if(nacionality == null || nacionality.length() == 0){
			throw new InputException(MessageConstant.INVALID_NACIONALITY_NOT_NULL);
		}
		if(nacionality.length() > 25){
			throw new InputException(MessageConstant.INVALID_NACIONALITY_LENGTH);
		}
		Pattern p = Pattern.compile("[^a-z0-9 ]", Pattern.CASE_INSENSITIVE);
		Matcher m = p.matcher(nacionality);
		if (m.find()){
			throw new InputException(MessageConstant.INVALID_NACIONALITY_FORMAT);
		}
		return true;
	}

	public static boolean validationOfDate(String date) throws InputException{
		Date enteredDate=null;
		try{
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			enteredDate = sdf.parse(date);
		}catch (Exception ex)
		{
			throw new InputException(MessageConstant.INVALID_DATE);
		}
		Date currentDate = new Date();      
		if(enteredDate.after(currentDate)){
			throw new InputException(MessageConstant.INVALID_DATE);
		}else
			return true;
	}
	
	public static boolean validateDocument(String documentId, String documenType) throws Exception {
		
		if(documentId == null || documentId.length() == 0) {
			throw new InputException(MessageConstant.DOCUMENT_NOT_VALID);
		}
		
		if(documenType == null || documenType.length() == 0) {
			throw new InputException(MessageConstant.INVALID_DOCUMENT_TYPE);
		}
		
		DocumentTypeFactory.getDocumentType(documenType, documentId);
		
		return true;
	}
	
	public static boolean validateGender(String gender) throws InputException {
		if(gender == null || gender.length() == 0) {
			throw new InputException(MessageConstant.INVALID_GENDER_OPTION);
		}
		return true;
	}
	
}
