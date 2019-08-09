package com.person.api.service;

import java.util.List;

import com.person.api.dto.PersonDto;
import com.person.api.entity.PersonEntity;
import com.person.api.exception.UserNotFoundException;


/**
 * UsuarioService
 */
public interface PersonService {

    List<PersonEntity> findAllPerson();

	public PersonEntity findPerson(Integer idPerson) throws UserNotFoundException;
	
	public PersonEntity updatePerson(PersonDto person);

	public PersonEntity createPerson(PersonDto person);
	
	public PersonEntity deletePerson(Integer idPerson) throws UserNotFoundException;
	
}