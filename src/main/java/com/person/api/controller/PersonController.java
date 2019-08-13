package com.person.api.controller;

import java.text.DateFormat;
import java.util.List;
import java.text.SimpleDateFormat;

import com.person.api.constant.MessageConstant;
import com.person.api.dto.PersonDto;
import com.person.api.entity.PersonEntity;
import com.person.api.entity.RelationshipEntity;
import com.person.api.exception.InputException;
import com.person.api.exception.MismatchTypeFieldException;
import com.person.api.exception.UserNotFoundException;
import com.person.api.repository.PersonRepository;
import com.person.api.service.PersonService;
import com.person.api.service.RelationshipService;
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

	@Autowired
	private RelationshipService relationshipService;
	
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
	public PersonEntity updatePerson(@PathVariable String id, @RequestBody PersonDto person) throws Exception{
		
		GeneralValidator.validateId(id);
		
		try { 

			
			DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");  
			String strDate = dateFormat.format(person.getDate_of_birth());  

			if(GeneralValidator.validationOfName(person.getName(), person.getLast_name()) && GeneralValidator.validateDocument(person.getDocument_id(), person.getDocument_type()) && GeneralValidator.validationOfDate(strDate) 
				&& GeneralValidator.validateGender(person.getGender()) && GeneralValidator.validationOfNacionality(person.getNationality()) && GeneralValidator.validateContact(person.getContact())){
				return personService.updatePerson(person);
			}
			else{
				throw new InputException(MessageConstant.INVALID_FORMAT);
			}
		} catch (Exception returnedException) {
			throw returnedException;
		}
	}

	@CrossOrigin
	@PostMapping("/")
	public PersonEntity createPerson(@RequestBody PersonDto person) throws Exception{
		try {
			DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");  
			String strDate = dateFormat.format(person.getDate_of_birth());  

			if(GeneralValidator.validationOfName(person.getName(), person.getLast_name())  && GeneralValidator.validateDocument(person.getDocument_id(), person.getDocument_type()) && GeneralValidator.validationOfDate(strDate) 
				&& GeneralValidator.validateGender(person.getGender()) && GeneralValidator.validationOfNacionality(person.getNationality()) && GeneralValidator.validateContact(person.getContact())){
				return personService.createPerson(person);
			}
			else{
				throw new InputException(MessageConstant.INVALID_FORMAT);
			}
		} catch (Exception returnedException) {
			throw returnedException;
		}
	}
	
	@CrossOrigin
	@DeleteMapping(value = "/{id}")
	public PersonEntity deletePerson(@PathVariable String id)  throws UserNotFoundException, MismatchTypeFieldException{
		
		Integer personId = GeneralValidator.validateId(id);
		List<RelationshipEntity> relations = relationshipService.findByIdFirstPerson(personId);
		for(int i = 0; i < relations.size(); i++){
			relationshipService.deleteRelationship(relations.get(i).getId());
		}
		return personService.deletePerson(personId);
	}
}