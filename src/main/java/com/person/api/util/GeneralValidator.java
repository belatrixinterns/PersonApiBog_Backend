package com.person.api.util;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.person.api.constant.MessageConstant;
import com.person.api.constant.TypeConstant;
import com.person.api.constant.document.DocumentTypeFactory;
import com.person.api.exception.InputException;
import com.person.api.exception.MismatchTypeFieldException;

import net.bytebuddy.implementation.bytecode.Throw;

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
		Pattern lettersPattern = Pattern.compile("/^[\u00F1A-Za-z _]*[\u00F1A-Za-z][\u00F1A-Za-z _]*$/", Pattern.CASE_INSENSITIVE);
		Pattern numericPattern = Pattern.compile("[0-9]+", Pattern.CASE_INSENSITIVE);
		Matcher matcherLetters = lettersPattern.matcher(name);
		Matcher matcherNumeric = numericPattern.matcher(name);
		if (!matcherLetters.find() && matcherNumeric.find()){
			throw new InputException(MessageConstant.INVALID_NAME_FORMAT);
		}
		matcherLetters = lettersPattern.matcher(lastName);
		matcherNumeric = numericPattern.matcher(lastName);
		if (!matcherLetters.find() && matcherNumeric.find()){
			throw new InputException(MessageConstant.INVALID_LAST_NAME_FORMAT);
		}
		return true;
	}

	public static boolean validationOfNacionality(String nacionality) throws InputException{
		if(nacionality == null || nacionality.length() == 0){
			throw new InputException(MessageConstant.INVALID_NACIONALITY_NOT_NULL);
		}
		if(nacionality.length() > 3){
			throw new InputException(MessageConstant.INVALID_NACIONALITY_LENGTH);
		}
        Pattern lettersPattern = Pattern.compile("[a-zA-Z]", Pattern.CASE_INSENSITIVE);
		Pattern numericPattern = Pattern.compile("[0-9]+", Pattern.CASE_INSENSITIVE);
		Matcher matcherLetters = lettersPattern.matcher(nacionality);
		Matcher matcherNumeric = numericPattern.matcher(nacionality);
		if (matcherLetters.find() || !matcherNumeric.find()){
			throw new InputException(MessageConstant.INVALID_NACIONALITY_FORMAT);
		}
		return true;
	}

	public static boolean validationOfDate(String date) throws InputException{
		Date enteredDate=null;
		try{
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
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
	
	public static boolean validateGender(String gender) throws InputException, MismatchTypeFieldException {
		Integer numericGender = null;
		
		if(gender == null || gender.length() == 0) {
			throw new InputException(MessageConstant.INVALID_GENDER_NOT_NULL);
		}
		
		try {
			numericGender = Integer.parseInt(gender);
		} catch (Exception e) {
			throw new MismatchTypeFieldException(MessageConstant.MISMATCH_TYPE_FIELD_MESSAGE+", the gender contains invalid characters, it only allows numbers");
		}
		
		if(!numericGender.equals(TypeConstant.GENDER_MASCULINE) && !numericGender.equals(TypeConstant.GENDER_FEMENINE)) {
			throw new MismatchTypeFieldException(MessageConstant.INVALID_GENDER_OPTION);
		}
		
		return true;
	}
	
	public static boolean validateContact(String contact) throws InputException, MismatchTypeFieldException {
		if(contact == null || contact.length() == 0) {
			return true;
		}
		Pattern numericPattern = Pattern.compile("^[0-9]+$", Pattern.CASE_INSENSITIVE);
		Pattern emailPattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
				+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
		boolean findedNumberPattern = numericPattern.matcher(contact).find();
		boolean findedEmailPattern = emailPattern.matcher(contact).find();
		
		if(findedNumberPattern && contact.length() > 15) {
			throw new InputException(MessageConstant.INVALID_LENGTH_MESSAGE+", the contact number has a maximum length of 15");
		}
		
		if(findedEmailPattern && contact.length() > 30) {
			throw new InputException(MessageConstant.INVALID_LENGTH_MESSAGE+", the contact email has a maximum length of 30");
		}
		
		if(!findedEmailPattern && !findedNumberPattern) {
			throw new MismatchTypeFieldException(MessageConstant.MISMATCH_TYPE_FIELD_MESSAGE+", please verify that your contact be a number or email");
		}
		
		
		return true;
	}
	
}
