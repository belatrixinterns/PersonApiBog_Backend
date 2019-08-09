package com.person.api.impl;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import com.person.api.converter.RelationshipConverter;
import com.person.api.dto.RelationshipDto;
import com.person.api.entity.RelationshipEntity;
import com.person.api.repository.RelationshipRepository;
import com.person.api.service.RelationshipService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * RelationshipServiceImpl
 */
@Service
public class RelationshipServiceImpl implements RelationshipService{
    @Autowired
	RelationshipRepository relationshipRepository;
	
    @Override
    public List<RelationshipEntity> findAllRelationship(){
		return StreamSupport.stream(relationshipRepository.findAll().spliterator(), false).collect(Collectors.toList());
    }
    
    @Override
	public RelationshipEntity findRelationship(Integer id) {
		return relationshipRepository.findById(id).get();
	}
	
	@Override
	public RelationshipEntity updateRelationship(RelationshipDto relationship) {
        RelationshipEntity relationshipM = relationshipRepository.findById(relationship.getId()).get();
		//update fields
		relationshipM.setIdFirstPerson(relationship.getIdFirstPerson());
		relationshipM.setIdSecondPerson(relationship.getIdSecondPerson());
		relationshipM.setIdRelationType(relationship.getIdRelationType());
		return relationshipRepository.save(relationshipM);
	}

	@Override
	public RelationshipEntity createRelationship(RelationshipDto relationship) {
        return relationshipRepository.save(RelationshipConverter.convertToEntity(relationship));
	}

	@Override
	public RelationshipEntity deleteRelationship(Integer id) {
		RelationshipEntity relationship = relationshipRepository.findById(id).get();
		relationshipRepository.delete(relationship);		
		return relationship;
	}

	@Override
	public List<RelationshipEntity> findByIdFirstPerson(Integer idFirstPerson){
		return relationshipRepository.findByIdFirstPerson(idFirstPerson);
	}
}