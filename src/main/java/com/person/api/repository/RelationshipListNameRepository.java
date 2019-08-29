package com.person.api.repository;

import com.person.api.entity.RelationshipListNamesEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * RelationshipRepository
 */
@Repository
public interface RelationshipListNameRepository extends CrudRepository<RelationshipListNamesEntity, Integer>{
}