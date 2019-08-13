package com.person.api.impl;

import com.person.api.entity.RelationTypeEntity;
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
	RelationTypeRepository relationshipRepository;
    
    @Override
	public RelationTypeEntity findRelationType(Integer id) {
		return relationshipRepository.findById(id).get();
    }
}