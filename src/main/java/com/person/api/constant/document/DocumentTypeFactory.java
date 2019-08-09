package com.person.api.constant.document;

import com.person.api.constant.MessageConstant;
import com.person.api.constant.TypeConstant;
import com.person.api.exception.MismatchTypeFieldException;

public class DocumentTypeFactory {
	
	private DocumentTypeFactory() {

	}
	
	public static DocumentType getDocumentType(String documentTypeIdentifier, String documentId) throws Exception {
		DocumentType documentType = null;
		
		switch (documentTypeIdentifier) {
		case TypeConstant.DOCUMENT_TYPE_CC:
			documentType = new DocumentTypeCC(documentTypeIdentifier, documentId);
			break;
		case TypeConstant.DOCUMENT_TYPE_CE:
			documentType = new DocumentTypeCE(documentTypeIdentifier, documentId);
			break;
		case TypeConstant.DOCUMENT_TYPE_TI:
			documentType = new DocumentTypeTI(documentTypeIdentifier, documentId);
			break;
		default:
			throw new MismatchTypeFieldException(MessageConstant.INVALID_DOCUMENT_TYPE);
		}
		return documentType;
	}
}
