package com.person.api.service;

import java.util.List;

import com.person.api.dto.RelationshipDto;
import com.person.api.entity.RelationshipEntity;
import com.person.api.exception.RelationshipNotFoundException;


/**
 * RelationshipService
 */
public interface RelationshipService {

    List<RelationshipEntity> findAllRelationship();

	public RelationshipEntity findRelationship(Integer id) throws RelationshipNotFoundException;
	
	public RelationshipEntity updateRelationship(RelationshipDto relationship) throws RelationshipNotFoundException;

	public RelationshipEntity createRelationship(RelationshipDto relationship);
	
	public RelationshipEntity deleteRelationship(Integer id) throws RelationshipNotFoundException;

	public List<RelationshipEntity> findByIdFirstPerson(Integer idFirstPerson) throws RelationshipNotFoundException;
	
	public List<RelationshipEntity> findByIdFirstPersonAndIdSecondPerson(Integer idFirstPerson, Integer idSecondPerson) throws RelationshipNotFoundException;

	public Integer findByIdFirstPersonAndIdRelationship(Integer idRelationship, Integer firstIdPerson);
	
	public boolean findRelationshipExistence(Integer idFirstPerson, Integer idSecondPerson) throws Exception;
}