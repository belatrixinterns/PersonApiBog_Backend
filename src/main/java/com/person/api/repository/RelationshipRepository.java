package com.person.api.repository;

import java.util.List;
import java.util.stream.Collector;

import com.person.api.entity.RelationshipEntity;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * RelationshipRepository
 */
@Repository
public interface RelationshipRepository extends CrudRepository<RelationshipEntity, Integer>{
    List<RelationshipEntity> findByIdFirstPerson(Integer idFirstPerson);
    
}