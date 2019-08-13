package com.person.api.controller;

import java.util.List;

import com.person.api.constant.MessageConstant;
import com.person.api.dto.RelationshipDto;
import com.person.api.entity.PersonEntity;
import com.person.api.entity.RelationTypeEntity;
import com.person.api.entity.RelationshipEntity;
import com.person.api.exception.BadRequestException;
import com.person.api.exception.MismatchTypeFieldException;
import com.person.api.exception.UserNotFoundException;
import com.person.api.repository.RelationshipRepository;
import com.person.api.service.PersonService;
import com.person.api.service.RelationTypeService;
import com.person.api.service.RelationshipService;
import com.person.api.util.GeneralValidator;

import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;

/**
 * UsuarioController
 */
@RestController
@RequestMapping("/relationship")
public class RelationshipController {
@Autowired
RelationshipRepository RelationshipRepository;
    
	@Autowired
	private RelationshipService relationshipService;
	
	@Autowired
	private RelationTypeService relationTypeService;

	@Autowired
	private PersonService personService;	
	
	@CrossOrigin
	@PostMapping("/")
	public RelationshipEntity createRelationship(@RequestBody RelationshipDto relationship) throws Exception{
		try {
			if(GeneralValidator.validatePerson(relationship.getIdFirstPerson()) || GeneralValidator.validateRelationType(relationship.getIdRelationType()) 
				|| GeneralValidator.validatePerson(relationship.getIdSecondPerson())){
				
				PersonEntity personOne = personService.findPerson(Integer.parseInt(relationship.getIdFirstPerson()));
				PersonEntity personTwo = personService.findPerson(Integer.parseInt(relationship.getIdSecondPerson()));
				RelationTypeEntity relationType = relationTypeService.findRelationType(Integer.parseInt(relationship.getIdRelationType()));

				if(!GeneralValidator.validatePersonExists(personOne, personTwo) || !GeneralValidator.validateRelationTypeExists(relationType)){
					throw new BadRequestException(MessageConstant.INVALID_FORMAT);
				}
				if(!GeneralValidator.validateRelationIntegrity(personOne, personTwo, relationType)){
					throw new BadRequestException(MessageConstant.INVALID_FORMAT);
				}
				return relationshipService.createRelationship(relationship);
			}
			else{
				throw new BadRequestException(MessageConstant.INVALID_FORMAT);
			}	
		} catch (Exception returnedException) {
			throw returnedException;
		}
	}

	@CrossOrigin
    @GetMapping("/")
    public List<RelationshipEntity> getAllRelationship() {
        return relationshipService.findAllRelationship();
    }

	@CrossOrigin
    @GetMapping("/{id}")
	public RelationshipEntity getRelationship(@PathVariable String id) throws UserNotFoundException, MismatchTypeFieldException  {

		Integer personId = GeneralValidator.validateId(id);
		return relationshipService.findRelationship(personId);
	}
	
	@CrossOrigin
	@PutMapping("/{id}")
	public RelationshipEntity updateRelationship(@PathVariable Integer id, @RequestBody RelationshipDto relationship) throws Exception{
		try {
			if(GeneralValidator.validatePerson(relationship.getIdFirstPerson()) || GeneralValidator.validateRelationType(relationship.getIdRelationType()) || GeneralValidator.validatePerson(relationship.getIdSecondPerson())){
				return relationshipService.updateRelationship(relationship);
			}
			else{
				throw new BadRequestException(MessageConstant.INVALID_FORMAT);
			}	
		} catch (Exception returnedException) {
			throw returnedException;
		}
	}

	
	@CrossOrigin
	@DeleteMapping(value = "/{id}")
	public RelationshipEntity deleteRelationship(@PathVariable String id) throws UserNotFoundException, MismatchTypeFieldException{
		
		Integer personId = GeneralValidator.validateId(id);
		return relationshipService.deleteRelationship(personId);
		
	}
}