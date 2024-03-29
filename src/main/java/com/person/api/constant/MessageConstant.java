package com.person.api.constant;

public class MessageConstant {
	
	private MessageConstant() {
	    throw new IllegalStateException("Utility class");
	  }
	
	public static final String AFTER_TODAY_MESSAGE = "The person can't not have a birth day which is a future date or a date before of 1900";
	
	public static final String DEFAULT_MESSAGE = "The app crashed, please contact to the administrator";
	
	public static final String DUPLICATE_PERSON_DOCUMENT_ID_MESSAGE = "The person with that document has already exist, please change it";

	public static final String DUPLICATE_PERSON_IDENTIFIER_MESSAGE = "The person document id has already exist, please change it";
	
	public static final String EMPTY_FIELD_MESSAGE = "Empty field, please check your request";
	
	public static final String INVALID_COUNTRY_PREFIX_OPTION = "The country prefix should be real and must have 3 characters, please visit the available list of countries on https://www.iso.org/obp/ui/#search";
	
	public static final String INVALID_DATE_FORMAT = "The date must have the format aaaa-mm-dd";
		
	public static final String INVALID_DATE_NOT_NULL = "The date can't be empty";
	
	public static final String INVALID_LENGTH_MESSAGE = "One field has conflicts with the allowed length";
	
	public static final String INVALID_PERSON_NAME_MESSAGE = "The person name contains invalid characters, only allow alphabetic characters and spaces";

	public static final String MISMATCH_TYPE_FIELD_MESSAGE = "Mismatch type";
	
	public static final String USER_NOT_FOUND_MESSAGE = "The user can't be found, please provide a valid identifier";

	public static final String RELATIONSHIP_NOT_FOUND_MESSAGE = "The relationship can't be found, please provide a valid identifier.";
	
	public static final String USER_HAS_ALREADY_EXIST = "The user identified by that document id and document type has alredy exist";
			
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
	
	public static final String INVALID_DOCUMENT_NOT_NULL = "the document id can't be empty";
	
	public static final String INVALID_DOCUMENT_FIELD = MessageConstant.MISMATCH_TYPE_FIELD_MESSAGE+", the document id must have numeric characters";
	
	public static final String INVALID_DOCUMENT_TYPE = "the document type is invalid, only the types  CC, CE or TI are allowed";
  
  public static final String INVALID_DOCUMENT_CE_LENGTH = MessageConstant.INVALID_LENGTH_MESSAGE+", the document id for document type: CE has a max lenght of 20";

	public static final String INVALID_DOCUMENT_CE = MessageConstant.MISMATCH_TYPE_FIELD_MESSAGE+", the document id for document type: CE only allow alphanumerical characters";
  
	public static final String INVALID_USER_NOT_NULL = "The user can't be empty.";

	public static final String INVALID_USER_ID_FORMAT = "The id typed has a wrong format. Please use only numbers.";

	public static final String INVALID_RELATION_TYPE_ID_FORMAT = "The id typed has a wrong format. Please use only numbers.";

	public static final String INVALID_RELATION_TYPE_OPTION = "The id of the relation typed, don't match with any record. Please type a valid one.";

	public static final String INVALID_PERSON_OBJECT_NOT_NULL = "User not found. Please type a valid: ";

	public static final String INVALID_RELATION_TYPE_OBJECT_NOT_NULL = "Relation type not found. Please try another value.";

	public static final String INVALID_RELATION_POSIBILITY = "The kind of the relation typed is not allowed. Please try a new one.";

	public static final String INVALID_RELATION_EXIST = "The relation allready exist.";

	public static final String INVALID_RELATION_ONLY_TWO_GRANDPARENTS = "The relation two relations allready exist.";

	public static final String RELATIONSHIP_EXISTS = "The relationship already exists.";

	public static final String INVALID_RELATION_NOT_NULL = "The relation type can't be empty";

	public static final String INVALID_RELATION_TO_THE_SAME_PERSON = "A person can't be used in fields 'personOne' and 'personTwo' at the same time.";
}
