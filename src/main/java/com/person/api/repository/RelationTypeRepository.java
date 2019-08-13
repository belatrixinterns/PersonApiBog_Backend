package com.person.api.repository;

import com.person.api.entity.RelationTypeEntity;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * RelationshipRepository
 */
@Repository
public interface RelationTypeRepository extends CrudRepository<RelationTypeEntity, Integer>{
}