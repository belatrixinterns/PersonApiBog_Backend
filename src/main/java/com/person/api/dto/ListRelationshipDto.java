package com.person.api.dto;

import lombok.Data;

@Data
public class ListRelationshipDto {
	
	private Integer id;
	private String fullnamePerson1;
	private String relationType;
	private String fullnamePerson2;
	
	public ListRelationshipDto(Integer id, String fullnamePerson1, String relationType,
			String fullnamePerson2) {
		super();
		System.out.println(id+","+fullnamePerson1+","+relationType+","+fullnamePerson2);
		this.id = id;
		this.fullnamePerson1 = fullnamePerson1;
		this.relationType = relationType;
		this.fullnamePerson2 = fullnamePerson2;
	}
	
	public int getIdRelationship() {
		return id;
	}
	public void setIdRelationship(Integer idRelationship) {
		this.id = idRelationship;
	}
	public String getFullnamePerson1() {
		return fullnamePerson1;
	}
	public void setFullnamePerson1(String fullnamePerson1) {
		this.fullnamePerson1 = fullnamePerson1;
	}
	public String getRelationName() {
		return relationType;
	}
	public void setRelationName(String relationName) {
		this.relationType = relationName;
	}
	public String getFullnamePerson2() {
		return fullnamePerson2;
	}
	public void setFullnamePerson2(String fullnamePerson2) {
		this.fullnamePerson2 = fullnamePerson2;
	}
}
