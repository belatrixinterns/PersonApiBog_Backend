package com.person.api.service;

import java.util.List;

import com.person.api.dto.RelationshipDto;
import com.person.api.entity.RelationshipEntity;


/**
 * RelationshipService
 */
public interface RelationshipService {

    List<RelationshipEntity> findAllRelationship();

	public RelationshipEntity findRelationship(Integer id);
	
	public RelationshipEntity updateRelationship(RelationshipDto relationship);

	public RelationshipEntity createRelationship(RelationshipDto relationship);
	
	public RelationshipEntity deleteRelationship(Integer id);

	List<RelationshipEntity> findByIdFirstPerson(Integer idFirstPerson);
	
}