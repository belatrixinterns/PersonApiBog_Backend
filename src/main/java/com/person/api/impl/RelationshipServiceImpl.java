package com.person.api.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import com.person.api.constant.MessageConstant;
import com.person.api.converter.RelationshipConverter;
import com.person.api.dto.RelationshipDto;
import com.person.api.entity.RelationshipEntity;
import com.person.api.exception.RelationshipNotFoundException;
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
	public RelationshipEntity findRelationship(Integer id) throws RelationshipNotFoundException{
		Optional<RelationshipEntity> relationship = relationshipRepository.findById(id);
        if(relationship.isPresent()) {
        	return relationship.get();
        }else {
        	throw new RelationshipNotFoundException();
        }
	}
	
	@Override
	public RelationshipEntity updateRelationship(RelationshipDto relationship) throws RelationshipNotFoundException {
		
		Optional<RelationshipEntity> relation = relationshipRepository.findById(relationship.getId());
    	if(!relation.isPresent()) {
    		throw new RelationshipNotFoundException();
    	}
		
		RelationshipEntity relationshipM = relation.get();

		//update fields
		relationshipM.setIdFirstPerson(Integer.parseInt(relationship.getIdFirstPerson()));
		relationshipM.setIdSecondPerson(Integer.parseInt(relationship.getIdSecondPerson()));
		relationshipM.setIdRelationType(Integer.parseInt(relationship.getIdRelationType()));
		return relationshipRepository.save(relationshipM);
	}

	@Override
	public RelationshipEntity createRelationship(RelationshipDto relationship) {
        return relationshipRepository.save(RelationshipConverter.convertToEntity(relationship));
	}

	@Override
	public RelationshipEntity deleteRelationship(Integer id) throws RelationshipNotFoundException {
		Optional<RelationshipEntity> relation = relationshipRepository.findById(id);
    	if(relation.isPresent()) {
    		RelationshipEntity currentRelationship = relation.get();
    		relationshipRepository.delete(currentRelationship);
    		return currentRelationship;
    	}else {
    		throw new RelationshipNotFoundException();
    	}
	}

	@Override
	public List<RelationshipEntity> findByIdFirstPerson(Integer idFirstPerson) throws RelationshipNotFoundException{
		List<RelationshipEntity> relationship = relationshipRepository.findByIdFirstPerson(idFirstPerson);
        if(relationship.size() > 0) {
        	return relationship;
        }else {
        	throw new RelationshipNotFoundException(MessageConstant.INVALID_RELATION_TYPE_OBJECT_NOT_NULL);
        }
	}

	@Override
	public List<RelationshipEntity> findByIdFirstPersonAndIdSecondPerson(Integer idFirstPerson, Integer idSecondPerson) throws RelationshipNotFoundException{
		List<RelationshipEntity> relationship = relationshipRepository.findByIdFirstPersonAndIdSecondPerson(idFirstPerson, idSecondPerson);
        if(relationship.size() > 0) {
        	return relationship;
        }else {
        	throw new RelationshipNotFoundException(MessageConstant.RELATIONSHIP_NOT_FOUND_MESSAGE);
        }
	}

	@Override
	public boolean findRelationshipExistence(Integer idFirstPerson, Integer idSecondPerson) throws Exception{
		List<RelationshipEntity> relationship = relationshipRepository.findRelationshipExistence(idFirstPerson, idSecondPerson);
		if(relationship.size() > 0) {
        	return true;
        }else if(relationship.size() == 0){
        	return false;
		}
		else{
			throw new Exception(MessageConstant.DEFAULT_MESSAGE);
		}
	}
}