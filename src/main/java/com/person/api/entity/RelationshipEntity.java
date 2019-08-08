package com.person.api.entity;

import javax.persistence.*;

@Entity
@Table(name = "relationship")
public class RelationshipEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "id_first_person")
    private Integer idFirstPerson;
    @Column(name = "id_second_person")
    private Integer idSecondPerson;
    @Column(name = "id_relation_type")
    private Integer idRelationType;
    

    public RelationshipEntity(){
    }

    public RelationshipEntity(Integer idFirstPerson, Integer idSecondPerson, Integer idRelationType){
        this.idFirstPerson = idFirstPerson;
        this.idSecondPerson = idSecondPerson;
        this.idRelationType = idRelationType;
    }

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