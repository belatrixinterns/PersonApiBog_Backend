package com.person.api.entity;

import java.util.Date;
//import java.util.Set;

import javax.persistence.*;

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
    @Column(name = "date_of_birth")
    private Date dateOfBirth;
    @Column(name = "document_type")
    private String documentType;
    @Column(name = "gender")
    private String gender;
    @Column(name = "nationality")
    private String nationality;

    //@OneToMany(cascade=CascadeType.REMOVE)
    //@JoinColumn(name="id_first_person")
    //private Set<RelationshipEntity> accounts;

    public PersonEntity(){
    }

    public PersonEntity(Integer id, String documentId, String name, String lastName, Date dateOfBirth, String documentType, String gender, String nationality ){
        this.id=null;
        this.documentId=documentId;
        this.name=name;
        this.lastName=lastName;
        this.dateOfBirth=dateOfBirth;
        this.documentType=documentType;
        this.gender=gender;
        this.nationality=nationality;
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
}