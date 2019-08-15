package com.person.api.impl;

import java.util.Optional;

import com.person.api.constant.MessageConstant;
import com.person.api.entity.RelationTypeEntity;
import com.person.api.exception.BadRequestException;
import com.person.api.repository.RelationTypeRepository;
import com.person.api.service.RelationTypeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * RelationshipServiceImpl
 */
@Service
public class RelationTypeServiceImpl implements RelationTypeService{
    @Autowired
	RelationTypeRepository relationTypeRepository;
    
    @Override
	public RelationTypeEntity findRelationType(Integer id) throws BadRequestException {
		Optional<RelationTypeEntity> relationType = relationTypeRepository.findById(id);
        	if(relationType.isPresent()) {
        		return relationType.get();
        	}else {
        		throw new BadRequestException(MessageConstant.INVALID_RELATION_TYPE_OBJECT_NOT_NULL);
        	}
    }
}