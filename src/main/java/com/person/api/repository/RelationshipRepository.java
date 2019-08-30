package com.person.api.repository;

import java.util.List;

import com.person.api.entity.RelationshipEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * RelationshipRepository
 */
@Repository
public interface RelationshipRepository extends CrudRepository<RelationshipEntity, Integer>{
    List<RelationshipEntity> findByIdFirstPerson(Integer idFirstPerson);
    
	@Query(value ="SELECT * FROM relationship WHERE id_second_person = :firstIdPerson AND id_relation_type = :idRelationship", nativeQuery = true)
    public List<RelationshipEntity> findByIdFirstPersonAndIdRelationship(Integer idRelationship, Integer firstIdPerson);

    @Query(value ="SELECT * FROM relationship WHERE id_first_person = :firstId AND id_second_person = :secondId", nativeQuery = true)
    List<RelationshipEntity> findByIdFirstPersonAndIdSecondPerson(@Param("firstId") Integer idFirstPerson, @Param("secondId") Integer idSecondPerson);
    
    @Query(value ="SELECT * FROM relationship WHERE id_first_person = :firstId AND id_second_person = :secondId", nativeQuery = true)
    List<RelationshipEntity> findRelationshipExistence(@Param("firstId") Integer idFirstPerson, @Param("secondId") Integer idSecondPerson);

    @Query(value ="SELECT * FROM relationship WHERE id_first_person = :firstId AND id_second_person = :secondId AND id != :idRelationship", nativeQuery = true)
    List<RelationshipEntity> findAnotherRelationship(@Param("firstId") Integer idFirstPerson, @Param("secondId") Integer idSecondPerson, @Param("idRelationship") Integer idRelationship);
}