package com.person.api.constant.document;

import java.util.regex.Pattern;

import com.person.api.constant.MessageConstant;
import com.person.api.constant.TypeConstant;
import com.person.api.exception.MismatchTypeFieldException;

public class DocumentTypeCE extends DocumentType{

	public DocumentTypeCE(String documentType, String documentId) throws Exception {
		super(TypeConstant.DOCUMENT_TYPE_CE, documentId);
	}

	@Override
	public  void validateDocumentId() throws MismatchTypeFieldException {

		if(this.getDocumentId().length() > 20) {			
			throw new MismatchTypeFieldException(MessageConstant.INVALID_DOCUMENT_CE_LENGTH);
		}
		
		Pattern alfaNumericPattern = Pattern.compile("^[0-9a-zA-Z]+$", Pattern.CASE_INSENSITIVE);
		
		if(!alfaNumericPattern.matcher(this.getDocumentId()).find()) {
			throw new MismatchTypeFieldException(MessageConstant.INVALID_DOCUMENT_CE);
		}
	}

}
