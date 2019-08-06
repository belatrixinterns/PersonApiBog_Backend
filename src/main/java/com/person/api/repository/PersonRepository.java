package com.person.api.repository;

import com.person.api.entity.PersonEntity;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * UsuarioRepository
 */
@Repository
public interface PersonRepository extends CrudRepository<PersonEntity, Integer>{
}