package com.person.api.entity;

import java.util.Date;
import java.util.Set;


import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "person")
public class PersonEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "document_id")
    private String documentId;
    @Column(name = "name")
    private String name;
    @Column(name = "last_name")
    private String lastName;
    @JsonProperty("date_of_birth")
    @JsonFormat(pattern="yyyy-MM-dd")
    @Column(name = "date_of_birth")
    private Date dateOfBirth;
    @Column(name = "document_type")
    private String documentType;
    @Column(name = "gender")
    private String gender;
    @Column(name = "nationality")
    private String nationality;
    @Column(name = "contact")
    private String contact;

    @OneToMany(mappedBy = "idFirstPerson", cascade = CascadeType.ALL)
    private Set<RelationshipEntity> relationship;

    @OneToMany(mappedBy = "idSecondPerson", cascade = CascadeType.ALL)
    private Set<RelationshipEntity> relationshipPersonTwo;

    public PersonEntity(){
    }

    public PersonEntity(Integer id){
        this.id = id;
    }

    public PersonEntity(Integer id, String documentId, String name, String lastName, Date dateOfBirth, String documentType, String gender, String nationality, String contact){
        this.id=null;
        this.documentId=documentId;
        this.name=name;
        this.lastName=lastName;
        this.dateOfBirth=dateOfBirth;
        this.documentType=documentType;
        this.gender=gender;
        this.nationality=nationality;
        if(contact == null){
            this.contact = "";
        }
        else{
            this.contact = contact;
        }
    }

    /**
     * @return the date_of_birth
     */
    public Date getDate_of_birth() {
        return dateOfBirth;
    }
    /**
     * @return the document_id
     */
    public String getDocument_id() {
        return documentId;
    }
    /**
     * @return the document_type
     */
    public String getDocument_type() {
        return documentType;
    }
    /**
     * @return the gender
     */
    public String getGender() {
        return gender;
    }
    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }
    /**
     * @return the last_name
     */
    public String getLast_name() {
        return lastName;
    }
    /**
     * @return the name
     */
    public String getName() {
        return name;
    }
    /**
     * @return the nationality
     */
    public String getNationality() {
        return nationality;
    }
    /**
     * @return the relationship
     */
    public Set<RelationshipEntity> getRelationship() {
        return relationship;
    }
    /**
     * @return the contact
     */
    public String getContact() {
        if(contact == null){
            return "";
        }
        else{
            return contact;
        }
    }
    /**
     * @param date_of_birth the date_of_birth to set
     */
    public void setDate_of_birth(Date date_of_birth) {
        this.dateOfBirth = date_of_birth;
    }
    /**
     * @param document_id the document_id to set
     */
    public void setDocument_id(String document_id) {
        this.documentId = document_id;
    }
    /**
     * @param document_type the document_type to set
     */
    public void setDocument_type(String document_type) {
        this.documentType = document_type;
    }
    /**
     * @param gender the gender to set
     */
    public void setGender(String gender) {
        this.gender = gender;
    }
    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }
    /**
     * @param last_name the last_name to set
     */
    public void setLast_name(String last_name) {
        this.lastName = last_name;
    }
    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * @param nationality the nationality to set
     */
    public void setNationality(String nationality) {
        this.nationality = nationality;
    }
    /**
     * @param relationship the relationship to set
     */
    public void setRelationship(Set<RelationshipEntity> relationship) {
        this.relationship = relationship;
    }
    /**
     * @param contact the contact to set
     */
    public void setContact(String contact) {
        this.contact = contact;
    }
}