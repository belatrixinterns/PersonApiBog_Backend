package com.person.api.dto;

/**
 * RelationshipDto
 */
public class RelationshipDto {
    private Integer id;
    private String idFirstPerson;
    private String idSecondPerson;
    private String idRelationType;
    
    public RelationshipDto(String idFirstPerson, String idSecondPerson, String idRelationType){
        this.idFirstPerson = idFirstPerson;
        this.idSecondPerson = idSecondPerson;
        this.idRelationType = idRelationType;
    }

    public RelationshipDto(){}

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }
    /**
     * @return the idFirstPerson
     */
    public String getIdFirstPerson() {
        return idFirstPerson;
    }
    /**
     * @return the idRelationType
     */
    public String getIdRelationType() {
        return idRelationType;
    }
    /**
     * @return the idSecondPerson
     */
    public String getIdSecondPerson() {
        return idSecondPerson;
    }
    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }
    /**
     * @param idFirstPerson the idFirstPerson to set
     */
    public void setIdFirstPerson(String idFirstPerson) {
        this.idFirstPerson = idFirstPerson;
    }
    /**
     * @param idRelationType the idRelationType to set
     */
    public void setIdRelationType(String idRelationType) {
        this.idRelationType = idRelationType;
    }
    /**
     * @param idSecondPerson the idSecondPerson to set
     */
    public void setIdSecondPerson(String idSecondPerson) {
        this.idSecondPerson = idSecondPerson;
    }
}