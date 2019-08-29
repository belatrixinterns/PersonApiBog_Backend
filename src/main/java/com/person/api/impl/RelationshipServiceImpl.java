package com.person.api.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import com.person.api.constant.MessageConstant;
import com.person.api.constant.TypeConstant;
import com.person.api.converter.RelationshipConverter;
import com.person.api.dto.RelationshipDto;

import com.person.api.entity.PersonEntity;
import com.person.api.entity.RelationTypeEntity;
import com.person.api.entity.RelationshipEntity;
import com.person.api.entity.RelationshipListNamesEntity;
import com.person.api.exception.RelationshipNotFoundException;
import com.person.api.repository.PersonRepository;
import com.person.api.repository.RelationTypeRepository;
import com.person.api.repository.RelationshipListNameRepository;
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
	RelationshipListNameRepository relationshipListNameRepository;

    @Autowired
	RelationshipRepository relationshipRepository;

	@Autowired
	PersonRepository personRepository;

	@Autowired
	RelationTypeRepository relationTypeRepository;
	
    @Override
    public List<RelationshipEntity> findAllRelationship(){
		return StreamSupport.stream(relationshipRepository.findAll().spliterator(), false).collect(Collectors.toList());
    }
    
    @Override
    public List<RelationshipListNamesEntity> findAllRelationshipWithNames(){
    	return StreamSupport.stream(relationshipListNameRepository.findAll().spliterator(), false).collect(Collectors.toList());
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
		
		Optional<PersonEntity> personOne = personRepository.findById(Integer.parseInt(relationship.getIdFirstPerson()));
		Optional<PersonEntity> personTwo = personRepository.findById(Integer.parseInt(relationship.getIdSecondPerson()));
		Optional<RelationTypeEntity> relationType = relationTypeRepository.findById(Integer.parseInt(relationship.getIdRelationType()));


		//update fields
		relationshipM.setIdFirstPerson(personOne.get());
		relationshipM.setIdSecondPerson(personTwo.get());
		relationshipM.setIdRelationType(relationType.get());
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
	public Integer findByIdFirstPersonAndIdRelationship(Integer idRelationship, Integer firstIdPerson){
		List<RelationshipEntity> searchRelationchip = relationshipRepository.findByIdFirstPersonAndIdRelationship(idRelationship, firstIdPerson);
		if(searchRelationchip.size() > 0){
			if(idRelationship == TypeConstant.RELATION_TYPE_BROTHER || idRelationship == TypeConstant.RELATION_TYPE_GRANDMOTHER || idRelationship == TypeConstant.RELATION_TYPE_GRANDPARENT ){
				return searchRelationchip.size();
			}
			else{
				return -1;
			}
		}
		return 0;
	}

	
	@Override
	public boolean findRelationshipExistence(Integer idFirstPerson, Integer idSecondPerson, Integer idRelationship) throws Exception{
		List<RelationshipEntity> relationship = relationshipRepository.findRelationshipExistence(idFirstPerson, idSecondPerson);
		if(relationship.size() > 0 ) {
        	return true;
        }else if(relationship.size() == 0){
        	return false;
		}
		else{
			throw new Exception(MessageConstant.DEFAULT_MESSAGE);
		}
	}

	@Override
	public Integer findAnotherRelationship(Integer idFirstPerson, Integer idSecondPerson, Integer idRelationship){
		List<RelationshipEntity> searchRelationchip = relationshipRepository.findAnotherRelationship(idFirstPerson, idSecondPerson, idRelationship);
		if(searchRelationchip.size() > 0){
			if(idRelationship == TypeConstant.RELATION_TYPE_BROTHER || idRelationship == TypeConstant.RELATION_TYPE_GRANDMOTHER || idRelationship == TypeConstant.RELATION_TYPE_GRANDPARENT ){
				return searchRelationchip.size();
			}
			else{
				return -1;
			}
		}
		return 0;

	}
}