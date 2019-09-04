package com.person.api.controller;

import java.util.List;

import com.person.api.dto.PersonDto;
import com.person.api.entity.PersonEntity;
import com.person.api.exception.MismatchTypeFieldException;
import com.person.api.exception.UserNotFoundException;
import com.person.api.repository.PersonRepository;
import com.person.api.service.PersonService;
import com.person.api.util.GeneralValidator;

import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;

/**
 * PersonController
 */
@RestController
@RequestMapping("/person")
public class PersonController {

	@Autowired
	PersonRepository personRepository;
    
	@Autowired
	private PersonService personService;
	
	@CrossOrigin
    @GetMapping("/")
    public List<PersonEntity> getAllPerson() {
        return personService.findAllPerson();
    }

	@CrossOrigin
    @GetMapping("/{id}")
	public PersonEntity getPerson(@PathVariable String id) throws UserNotFoundException, MismatchTypeFieldException  {
		
		Integer personId = GeneralValidator.validateId(id);
		return personService.findPerson(personId); 
	}
	
	@CrossOrigin
	@PutMapping("/{id}")
	public PersonEntity updatePerson(@PathVariable String id, @RequestBody PersonDto person) throws MismatchTypeFieldException, Exception{

			Integer idPerson =  GeneralValidator.validateId(id);
			person.setId(idPerson);
  
			boolean personHasAlreadyExist = this.personService.findAnotherPersonWithTheSameDocument(idPerson, person.getDocument_id(), person.getDocument_type());

			if(GeneralValidator.validationOfName(person.getName(), person.getLast_name()) && GeneralValidator.validateDocument(person.getDocument_id(), person.getDocument_type(), personHasAlreadyExist) && GeneralValidator.validationOfDate(person.getDate_of_birth()) 
				&& GeneralValidator.validateGender(person.getGender()) && GeneralValidator.validationOfNacionality(person.getNationality()) && GeneralValidator.validateContact(person.getContact())){
		
			}
			return personService.updatePerson(person);
			
	}

	@CrossOrigin
	@PostMapping("/")
	public PersonEntity createPerson(@RequestBody PersonDto person) throws Exception{

			boolean personHasAlreayExist = this.personService.findAnotherPersonWithTheSameDocument(person.getId(),person.getDocument_id(), person.getDocument_type());
			
			if(GeneralValidator.validationOfName(person.getName(), person.getLast_name())  && GeneralValidator.validateDocument(person.getDocument_id(), person.getDocument_type(), personHasAlreayExist) && GeneralValidator.validationOfDate(person.getDate_of_birth()) 
				&& GeneralValidator.validateGender(person.getGender()) && GeneralValidator.validationOfNacionality(person.getNationality()) && GeneralValidator.validateContact(person.getContact())){
			}
			
			return personService.createPerson(person);
			
	}
	
	@CrossOrigin
	@DeleteMapping(value = "/{id}")
	public PersonEntity deletePerson(@PathVariable String id)  throws UserNotFoundException, MismatchTypeFieldException{
		  Integer personId = GeneralValidator.validateId(id);
			return personService.deletePerson(personId);
	}
}