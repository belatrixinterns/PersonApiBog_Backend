package com.person.api.constant.document;

import com.person.api.constant.TypeConstant;
import com.person.api.exception.MismatchTypeFieldException;

public class DocumentTypeTI extends DocumentType{

	public DocumentTypeTI(String documentType, String documentId) throws Exception {
		super(TypeConstant.DOCUMENT_TYPE_TI, documentId);
	}

}
