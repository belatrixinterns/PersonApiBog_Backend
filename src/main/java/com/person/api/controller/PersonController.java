package com.person.api.controller;

import java.util.List;

import com.mysql.cj.protocol.Message;
import com.person.api.constant.MessageConstant;
import com.person.api.dto.PersonDto;
import com.person.api.entity.PersonEntity;
import com.person.api.exception.DefaultException;
import com.person.api.exception.MismatchTypeFieldException;
import com.person.api.exception.UserNotFoundException;
import com.person.api.repository.PersonRepository;
import com.person.api.service.PersonService;
import com.person.api.util.GeneralValidator;

import org.springframework.aop.ThrowsAdvice;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

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
	public PersonEntity updatePerson(@PathVariable Integer id, @RequestBody PersonDto person){
		return personService.updatePerson(person);
	}

	@CrossOrigin
	@PostMapping("/")
	public PersonEntity createPerson(@RequestBody PersonDto person){
		
		return personService.createPerson(person);
	}
	
	@CrossOrigin
	@DeleteMapping(value = "/{id}")
	public PersonEntity deletePerson(@PathVariable Integer id) {
		
		return personService.deletePerson(id);
		
	}
}