package com.person.api.repository;

import com.person.api.entity.RelationshipEntity;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * RelationshipRepository
 */
@Repository
public interface RelationshipRepository extends CrudRepository<RelationshipEntity, Integer>{
}