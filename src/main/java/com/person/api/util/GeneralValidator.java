package com.person.api.util;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


import com.person.api.constant.MessageConstant;
import com.person.api.constant.TypeConstant;
import com.person.api.constant.document.DocumentTypeFactory;
import com.person.api.entity.PersonEntity;
import com.person.api.entity.RelationTypeEntity;
import com.person.api.exception.BadRequestException;
import com.person.api.exception.InvalidRelationTypeException;
import com.person.api.exception.MismatchTypeFieldException;
import com.person.api.exception.UserHasAlreadyExistException;

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

	public static boolean validationOfName(String name, String lastName) throws BadRequestException{
		if(name == null || name.length() == 0){
			throw new BadRequestException(MessageConstant.INVALID_NAME_NOT_NULL);
		}
		if(lastName == null || lastName.length() == 0){
			throw new BadRequestException(MessageConstant.INVALID_LAST_NAME_NOT_NULL);
		}
		if(name.length() > 25){
			throw new BadRequestException(MessageConstant.INVALID_NAME_LENGTH);
		}
		if(lastName.length() > 25){
			throw new BadRequestException(MessageConstant.INVALID_LAST_NAME_LENGTH);
		}
		Pattern lettersPattern = Pattern.compile("/^[\u00F1A-Za-z _]*[\u00F1A-Za-z][\u00F1A-Za-z _]*$/", Pattern.CASE_INSENSITIVE);
		Pattern numericPattern = Pattern.compile("[0-9]+", Pattern.CASE_INSENSITIVE);
		Matcher matcherLetters = lettersPattern.matcher(name);
		Matcher matcherNumeric = numericPattern.matcher(name);
		if (!matcherLetters.find() && matcherNumeric.find()){
			throw new BadRequestException(MessageConstant.INVALID_NAME_FORMAT);
		}
		matcherLetters = lettersPattern.matcher(lastName);
		matcherNumeric = numericPattern.matcher(lastName);
		if (!matcherLetters.find() && matcherNumeric.find()){
			throw new BadRequestException(MessageConstant.INVALID_LAST_NAME_FORMAT);
		}
		return true;
	}

	public static boolean validationOfNacionality(String nacionality) throws BadRequestException{
		if(nacionality == null || nacionality.length() == 0){
			throw new BadRequestException(MessageConstant.INVALID_NACIONALITY_NOT_NULL);
		}
		if(nacionality.length() > 3){
			throw new BadRequestException(MessageConstant.INVALID_NACIONALITY_LENGTH);
		}
        Pattern lettersPattern = Pattern.compile("[a-zA-Z]", Pattern.CASE_INSENSITIVE);
		Pattern numericPattern = Pattern.compile("[0-9]+", Pattern.CASE_INSENSITIVE);
		Matcher matcherLetters = lettersPattern.matcher(nacionality);
		Matcher matcherNumeric = numericPattern.matcher(nacionality);
		if (matcherLetters.find() || !matcherNumeric.find()){
			throw new BadRequestException(MessageConstant.INVALID_NACIONALITY_FORMAT);
		}
		return true;
	}

	public static boolean validationOfDate(String date) throws BadRequestException{

			if(date == null || date.length() == 0) {
				throw new BadRequestException(MessageConstant.INVALID_DATE_NOT_NULL);
			}
			Date enteredDate = null;
			try {
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				enteredDate = sdf.parse(date);
			} catch (Exception e) {
				throw new BadRequestException(MessageConstant.INVALID_DATE_FORMAT);
			}

			@SuppressWarnings("deprecation")
			Date minimunDate = new Date(0, 0, 1);
			Date currentDate = new Date();      
			if(enteredDate.after(currentDate) || enteredDate.before(minimunDate)){
				throw new BadRequestException(MessageConstant.AFTER_TODAY_MESSAGE);
			}
			
			return true;
		
	}
	
	public static boolean validateDocument(String documentId, String documenType, boolean documentAlreadyExist) throws Exception {
		
		if(documentId == null || documentId.length() == 0) {
			throw new BadRequestException(MessageConstant.INVALID_DOCUMENT_NOT_NULL);
		}
		
		if(documenType == null || documenType.length() == 0) {
			throw new BadRequestException(MessageConstant.INVALID_DOCUMENT_TYPE);
		}
		
		DocumentTypeFactory.getDocumentType(documenType, documentId);
		
		if(documentAlreadyExist) {
			throw new UserHasAlreadyExistException();
		}
		
		
		return true;
	}
	
	public static boolean validateGender(String gender) throws BadRequestException, MismatchTypeFieldException {
		Integer numericGender = null;
		
		if(gender == null || gender.length() == 0) {
			throw new BadRequestException(MessageConstant.INVALID_GENDER_NOT_NULL);
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

	public static boolean validatePerson(String id) throws BadRequestException{
		if(id == null || id.isEmpty()){
			throw new BadRequestException(MessageConstant.INVALID_USER_NOT_NULL);
		}
		Pattern lettersPattern = Pattern.compile("[a-zA-Z]", Pattern.CASE_INSENSITIVE);
		Pattern numericPattern = Pattern.compile("[0-9]+", Pattern.CASE_INSENSITIVE);
		Matcher matcherLetters = lettersPattern.matcher(id);
		Matcher matcherNumeric = numericPattern.matcher(id);
		if (matcherLetters.find() || !matcherNumeric.find()){
			throw new BadRequestException(MessageConstant.INVALID_USER_ID_FORMAT);
		}
		return true;

	}

	public static boolean validateRelationType(String id) throws BadRequestException, InvalidRelationTypeException{
		if(id == null || id.isEmpty()){
			throw new BadRequestException(MessageConstant.INVALID_RELATION_NOT_NULL);
		}
		Pattern lettersPattern = Pattern.compile("[a-zA-Z]", Pattern.CASE_INSENSITIVE);
		Pattern numericPattern = Pattern.compile("[0-9]+", Pattern.CASE_INSENSITIVE);
		Matcher matcherLetters = lettersPattern.matcher(id);
		Matcher matcherNumeric = numericPattern.matcher(id);
		if (matcherLetters.find() || !matcherNumeric.find()){
			throw new BadRequestException(MessageConstant.INVALID_RELATION_TYPE_ID_FORMAT);
		}
		
		return true;
	}

	public static boolean validatePersonExists(PersonEntity personOne, PersonEntity personTwo) throws BadRequestException{
		if(personOne == null){
			throw new BadRequestException(MessageConstant.INVALID_PERSON_OBJECT_NOT_NULL + "Person One");
		}
		else if(personTwo == null){
			throw new BadRequestException(MessageConstant.INVALID_PERSON_OBJECT_NOT_NULL + "Person Two");
		}
		return true;	
	}

	public static boolean validateRelationTypeExists(RelationTypeEntity relationType) throws BadRequestException{
		if(relationType == null){
			throw new BadRequestException(MessageConstant.INVALID_RELATION_TYPE_OBJECT_NOT_NULL);
		}
		return true;
	}

	public static boolean validateRelationIntegrity(PersonEntity personOne, PersonEntity personTwo, RelationTypeEntity relationType) throws BadRequestException{
		if(personOne.getGender().equals(TypeConstant.GENDER_MASCULINE.toString()) && (relationType.getId() == TypeConstant.RELATION_TYPE_MOTHER 
			|| relationType.getId() == TypeConstant.RELATION_TYPE_SISTER || relationType.getId() == TypeConstant.RELATION_TYPE_GRANDMOTHER)){
			throw new BadRequestException(MessageConstant.INVALID_RELATION_POSIBILITY);
		}
		if(personOne.getGender().equals(TypeConstant.GENDER_FEMENINE.toString())  && (relationType.getId() == TypeConstant.RELATION_TYPE_FATHER 
			|| relationType.getId() == TypeConstant.RELATION_TYPE_BROTHER || relationType.getId() == TypeConstant.RELATION_TYPE_GRANDPARENT)){
			throw new BadRequestException(MessageConstant.INVALID_RELATION_POSIBILITY);
		}
		return true;
	}
	
	public static boolean validateContact(String contact) throws BadRequestException, MismatchTypeFieldException {
		if(contact == null || contact.length() == 0) {
			return true;
		}
		Pattern numericPattern = Pattern.compile("^[0-9]+$", Pattern.CASE_INSENSITIVE);
		Pattern emailPattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
				+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
		boolean findedNumberPattern = numericPattern.matcher(contact).find();
		boolean findedEmailPattern = emailPattern.matcher(contact).find();
		
		if(findedNumberPattern && contact.length() > 15) {
			throw new BadRequestException(MessageConstant.INVALID_LENGTH_MESSAGE+", the contact number has a maximum length of 15");
		}
		
		if(findedEmailPattern && contact.length() > 30) {
			throw new BadRequestException(MessageConstant.INVALID_LENGTH_MESSAGE+", the contact email has a maximum length of 30");
		}
		
		if(!findedEmailPattern && !findedNumberPattern) {
			throw new MismatchTypeFieldException(MessageConstant.MISMATCH_TYPE_FIELD_MESSAGE+", please verify that your contact be a number or email");
		}
		
		
		return true;
	}

	public static boolean relationToItself(String idFirstPerson, String idSecondPerson) throws BadRequestException{
		if(idFirstPerson.toString().equals(idSecondPerson.toString())){
			throw new BadRequestException(MessageConstant.INVALID_RELATION_TO_THE_SAME_PERSON);
		}
		return false;
	}
	
}
