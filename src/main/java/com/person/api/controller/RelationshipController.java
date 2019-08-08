package com.person.api.controller;

import java.util.List;

import com.person.api.dto.RelationshipDto;
import com.person.api.entity.RelationshipEntity;
import com.person.api.repository.RelationshipRepository;
import com.person.api.service.RelationshipService;

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

	
}