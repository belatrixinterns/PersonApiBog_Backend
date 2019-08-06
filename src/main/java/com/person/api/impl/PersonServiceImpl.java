package com.person.api.impl;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import com.person.api.converter.PersonConverter;
import com.person.api.dto.PersonDto;
import com.person.api.entity.PersonEntity;
import com.person.api.repository.PersonRepository;
import com.person.api.service.PersonService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * UsuarioServiceImpl
 */
@Service
public class PersonServiceImpl implements PersonService{
    @Autowired
	PersonRepository personRepository;
	
    @Override
    public List<PersonEntity> findAllPerson(){
        return StreamSupport.stream(personRepository.findAll().spliterator(), false).collect(Collectors.toList());
    }
    
    @Override
	public PersonEntity findPerson(Integer idPerson) {
		return personRepository.findById(idPerson).get();
	}
	
	@Override
	public PersonEntity updatePerson(PersonDto person) {
        PersonEntity personM = personRepository.findById(person.getId()).get();
		//update fields
		personM.setDate_of_birth(person.getDate_of_birth());
		personM.setDocument_id(person.getDocument_id());
		personM.setDocument_type(person.getDocument_type());
		personM.setGender(person.getGender());
		personM.setLast_name(person.getLast_name());
		personM.setName(person.getName());
		personM.setNationality(person.getNationality());
		return personRepository.save(personM);
	}

	@Override
	public PersonEntity createPerson(PersonDto person) {
        return personRepository.save(PersonConverter.convertToEntity(person));
	}

	@Override
	public PersonEntity deletePerson(Integer idPerson) {
		PersonEntity person = personRepository.findById(idPerson).get();
		personRepository.delete(person);		
		return person;
	}
}