package com.person.api.controller;

import java.util.List;

import com.person.api.dto.PersonDto;
import com.person.api.entity.PersonEntity;
import com.person.api.entity.RelationshipEntity;
import com.person.api.repository.PersonRepository;
import com.person.api.service.PersonService;
import com.person.api.service.RelationshipService;

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
	public PersonEntity getPerson(@PathVariable Integer id) {
		return personService.findPerson(id);
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
		List<RelationshipEntity> relations = relationshipService.findByIdFirstPerson(id);
		for(int i = 0; i < relations.size(); i++){
			relationshipService.deleteRelationship(relations.get(i).getId());
		}
		return personService.deletePerson(id);
	}
}