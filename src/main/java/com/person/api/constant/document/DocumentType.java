package com.person.api.constant.document;

import com.person.api.constant.MessageConstant;
import com.person.api.exception.MismatchTypeFieldException;

public class DocumentType {
	
	private String documentTypeIdentifier = "";
	private String documentId = "";
	
	public DocumentType(String documentType, String documentId) throws MismatchTypeFieldException {
		this.setDocumentTypeIdentifier(documentType);
		this.setDocumentId(documentId);
		this.validateDocumentId();
	}
	
	public  void validateDocumentId() throws MismatchTypeFieldException {

		if(this.getDocumentId().length() > 10) {			
			throw new MismatchTypeFieldException(MessageConstant.INVALID_DOCUMENT_CE_LENGTH);
		}
		
		try {
			Integer.parseInt(this.getDocumentId());
		} catch (Exception e) {
			throw new MismatchTypeFieldException(MessageConstant.INVALID_DOCUMENT_FIELD);
		}
		
	}

	public String getDocumentTypeIdentifier() {
		return documentTypeIdentifier;
	}

	public void setDocumentTypeIdentifier(String documentTypeIdentifier) {
		this.documentTypeIdentifier = documentTypeIdentifier;
	}

	public String getDocumentId() {
		return documentId;
	}

	public void setDocumentId(String documentId) {
		this.documentId = documentId;
	}
}
