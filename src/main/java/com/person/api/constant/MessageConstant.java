package com.person.api.constant;

public class MessageConstant {
	
	private MessageConstant() {
	    throw new IllegalStateException("Utility class");
	  }
	
	public static final String AFTER_TODAY_MESSAGE = "The person must be exist, check the date";
	
	public static final String DEFAULT_MESSAGE = "The app crashed, please contact to the administrator";
	
	public static final String DUPLICATE_PERSON_DOCUMENT_ID_MESSAGE = "The person with that document has already exist, please change it";

	public static final String DUPLICATE_PERSON_IDENTIFIER_MESSAGE = "The person document id has already exist, please change it";
	
	public static final String EMPTY_FIELD_MESSAGE = "Empty field, please check your request";
	
	public static final String INVALID_COUNTRY_PREFIX_OPTION = "The country prefix should be real and must have 3 characters, please visit the available list of countries on https://www.iso.org/obp/ui/#search";
	
	public static final String INVALID_DATE_FORMAT = "The date must have the format aaaa-mm-dd";
		
	public static final String INVALID_LENGTH_MESSAGE = "One field has conflicts with the allowed length";
	
	public static final String INVALID_PERSON_NAME_MESSAGE = "The person name contains invalid characters, only allow alphabetic characters and spaces";

	public static final String MISMATCH_TYPE_FIELD_MESSAGE = "Mismatch type";
	
	public static final String USER_NOT_FOUND_MESSAGE = "The user can't be found, please provide a valid identifier";

	public static final String RELATIONSHIP_NOT_FOUND_MESSAGE = "The relationship can't be found, please provide a valid identifier.";
	
	public static final String INVALID_LAST_NAME_LENGTH = "The length of the last name is invalid";
	
	public static final String INVALID_LAST_NAME_FORMAT = "The last name is invalid, have special characters or numbers";
	
	public static final String INVALID_NAME_LENGTH = "The length of the name is invalid";
	
	public static final String INVALID_NAME_FORMAT = "The name is invalid, have special characters or numbers";
	
	public static final String INVALID_DATE = "The date is invalid";
	
	public static final String INVALID_LAST_NAME_NOT_NULL = "The last name can't be empty";
	
	public static final String INVALID_NAME_NOT_NULL = "The name cant be empty";
	
	public static final String INVALID_FORMAT = "The format of the POST body is incorrect ";
	
	public static final String INVALID_NACIONALITY_NOT_NULL = "The nacionality cant be empty ";
	
	public static final String INVALID_NACIONALITY_LENGTH = "The length of the nacionality is invalid ";
	
	public static final String INVALID_NACIONALITY_FORMAT = "The nacionality is invalid, don't have special characters or letters ";

	public static final String INVALID_GENDER_NOT_NULL = "The gender can't be empty";

	public static final String INVALID_GENDER_OPTION = "The gender is invalid, the valid gender formats are: 'masculine: 1 or femenine: 0' ";
	
	public static final String DOCUMENT_NOT_VALID = "the document id is invalid, please verify the document id provided";
	
	public static final String INVALID_DOCUMENT_TYPE = "the document type is invalid, only the types  CC, CE or TI are allowed";

	public static final String INVALID_USER_NOT_NULL = "The user can't be empty.";

	public static final String INVALID_USER_ID_FORMAT = "The id typed has a worng format. Please use only numbers.";

	public static final String INVALID_RELATION_TYPE_OPTION = "The id of the relation typed, don't match with any record. Please type a valid one.";
}
