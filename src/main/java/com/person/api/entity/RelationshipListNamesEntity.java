package com.person.api.entity;

import javax.persistence.*;


@Entity
@Table(name = "listkinships")
public class RelationshipListNamesEntity {

	@Id
	@Column(name = "id")
	private Integer id;

	@Column(name = "person_one")
	private String personOne;
	
	@Column(name = "relation")
	private String relation;
	
	@Column(name = "person_two")
	private String personTwo;
	
	public RelationshipListNamesEntity() {}
	
	public RelationshipListNamesEntity(Integer id, String personOne, String relation, String personTwo) {
		super();
		this.id = id;
		this.personOne = personOne;
		this.relation = relation;
		this.personTwo = personTwo;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPersonOne() {
		return personOne;
	}

	public void setPersonOne(String personOne) {
		this.personOne = personOne;
	}

	public String getRelation() {
		return relation;
	}

	public void setRelation(String relation) {
		this.relation = relation;
	}

	public String getPersonTwo() {
		return personTwo;
	}

	public void setPersonTwo(String personTwo) {
		this.personTwo = personTwo;
	}
	
	
}