package com.person.api.service;


import java.util.List;

import com.person.api.dto.PersonDto;
import com.person.api.entity.PersonEntity;
import com.person.api.exception.BadRequestException;
import com.person.api.exception.UserNotFoundException;


/**
 * UsuarioService
 */
public interface PersonService {

    List<PersonEntity> findAllPerson();

	public PersonEntity findPerson(Integer idPerson) throws UserNotFoundException;
	
	public boolean findAnotherPersonWithTheSameDocument(Integer id,String document, String documentType);
	
	public PersonEntity updatePerson(PersonDto person) throws UserNotFoundException, BadRequestException;

	public PersonEntity createPerson(PersonDto person) throws BadRequestException;
	
	public PersonEntity deletePerson(Integer idPerson) throws UserNotFoundException;

}