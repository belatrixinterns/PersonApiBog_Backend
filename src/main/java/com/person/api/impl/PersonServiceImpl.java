package com.person.api.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import com.person.api.constant.MessageConstant;
import com.person.api.converter.PersonConverter;
import com.person.api.dto.PersonDto;
import com.person.api.entity.PersonEntity;
import com.person.api.exception.BadRequestException;
import com.person.api.exception.UserNotFoundException;
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
	public PersonEntity findPerson(Integer idPerson) throws UserNotFoundException{
    		Optional<PersonEntity> person = personRepository.findById(idPerson);
        	if(person.isPresent()) {
        		return person.get();
        	}else {
        		throw new UserNotFoundException();
        	}
	}
	
	@Override
	public PersonEntity updatePerson(PersonDto person) throws UserNotFoundException, BadRequestException {
		Optional<PersonEntity> personOptional = personRepository.findById(person.getId());
    	if(!personOptional.isPresent()) {
    		throw new UserNotFoundException();
    	}
		
        PersonEntity personM = personOptional.get();
		//update fields
        
        try {
        	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    		Date enteredDate = sdf.parse(person.getDate_of_birth());
    		
    		personM.setDate_of_birth(enteredDate);
    		personM.setDocument_id(person.getDocument_id());
    		personM.setDocument_type(person.getDocument_type());
    		personM.setGender(person.getGender());
    		personM.setLast_name(person.getLast_name());
    		personM.setName(person.getName());
    		personM.setNationality(person.getNationality());
    		personM.setContact(person.getContact());
    		return personRepository.save(personM);
    		
		} catch (Exception e) {
			throw new BadRequestException(MessageConstant.INVALID_DATE);
		}
        

		
	}

	@Override
	public PersonEntity createPerson(PersonDto person) throws BadRequestException {
		PersonEntity personConverted = null;
		try {
			personConverted = PersonConverter.convertToEntity(person);
		} catch (Exception e) {
			throw new BadRequestException(MessageConstant.INVALID_DATE_FORMAT);
		}
		
        return personRepository.save(personConverted);
	}

	@Override
	public PersonEntity deletePerson(Integer idPerson) throws UserNotFoundException {
		Optional<PersonEntity> person = personRepository.findById(idPerson);
    	if(person.isPresent()) {
    		PersonEntity currentPerson = person.get();
    		personRepository.delete(currentPerson);
    		return currentPerson;
    	}else {
    		throw new UserNotFoundException();
    	}
    	
	}

	@Override
	public boolean findAnotherPersonWithTheSameDocument(Integer idPerson, String document, String documentType) {
		List<PersonEntity> personList = StreamSupport.stream(personRepository.findAll().spliterator(), false).collect(Collectors.toList());
    	boolean anotherPersonFounded = false;
		
		for (PersonEntity personEntity : personList) {
			
			if(personEntity.getDocument_id().equals(document) && personEntity.getDocument_type().equals(documentType) && !personEntity.getId().equals(idPerson)) {
				anotherPersonFounded = true;
			}
		}
    	return anotherPersonFounded;
	}
}