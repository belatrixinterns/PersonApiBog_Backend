package com.person.api.service;

import com.person.api.entity.RelationTypeEntity;
import com.person.api.exception.BadRequestException;


/**
 * RelationshipService
 */
public interface RelationTypeService {

	public RelationTypeEntity findRelationType(Integer id) throws BadRequestException;
	
	
}