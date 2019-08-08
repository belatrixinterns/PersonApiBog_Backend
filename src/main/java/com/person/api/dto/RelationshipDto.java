package com.person.api.dto;

/**
 * RelationshipDto
 */
public class RelationshipDto {
    private Integer id;
    private Integer idFirstPerson;
    private Integer idSecondPerson;
    private Integer idRelationType;
    
    public RelationshipDto(Integer idFirstPerson, Integer idSecondPerson, Integer idRelationType){
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
    public Integer getIdFirstPerson() {
        return idFirstPerson;
    }
    /**
     * @return the idRelationType
     */
    public Integer getIdRelationType() {
        return idRelationType;
    }
    /**
     * @return the idSecondPerson
     */
    public Integer getIdSecondPerson() {
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
    public void setIdFirstPerson(Integer idFirstPerson) {
        this.idFirstPerson = idFirstPerson;
    }
    /**
     * @param idRelationType the idRelationType to set
     */
    public void setIdRelationType(Integer idRelationType) {
        this.idRelationType = idRelationType;
    }
    /**
     * @param idSecondPerson the idSecondPerson to set
     */
    public void setIdSecondPerson(Integer idSecondPerson) {
        this.idSecondPerson = idSecondPerson;
    }
}