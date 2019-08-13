package com.person.api.controller;

import java.util.List;

import com.person.api.dto.RelationshipDto;
import com.person.api.entity.RelationshipEntity;
import com.person.api.exception.MismatchTypeFieldException;
import com.person.api.exception.UserNotFoundException;
import com.person.api.repository.RelationshipRepository;
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
	
	@CrossOrigin
	@PostMapping("/")
	public RelationshipEntity createRelationship(@RequestBody RelationshipDto Relationship){
		return relationshipService.createRelationship(Relationship);
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
	public RelationshipEntity updateRelationship(@PathVariable Integer id, @RequestBody RelationshipDto Relationship){
		
		return relationshipService.updateRelationship(Relationship);
	}

	
	@CrossOrigin
	@DeleteMapping(value = "/{id}")
	public RelationshipEntity deleteRelationship(@PathVariable Integer id) {
		
		return relationshipService.deleteRelationship(id);
		
	}
}