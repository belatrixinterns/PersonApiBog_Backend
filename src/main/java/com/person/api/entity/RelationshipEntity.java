package com.person.api.entity;

import javax.persistence.*;

import lombok.Data;

@Data
@Entity
@Table(name = "relationship")
public class RelationshipEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "id_first_person")
    private PersonEntity idFirstPerson;
    @ManyToOne
    @JoinColumn(name = "id_second_person")
    private PersonEntity idSecondPerson;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_relation_type")
    private RelationTypeEntity idRelationType;  

    public RelationshipEntity(){
    }

    public RelationshipEntity(Integer idFirstPerson, Integer idSecondPerson, Integer idRelationType){
        this.idFirstPerson = new PersonEntity(idFirstPerson);
        this.idSecondPerson = new PersonEntity(idSecondPerson);
        this.idRelationType = new RelationTypeEntity(idRelationType);
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
        return idFirstPerson.getId();
    }
    /**
     * @return the idRelationType
     */
    public Integer getIdRelationType() {
        return idRelationType.getId();
    }
    /**
     * @return the idSecondPerson
     */
    public Integer getIdSecondPerson() {
        return idSecondPerson.getId();
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
        this.idFirstPerson.setId(idFirstPerson);
    }
    /**
     * @param idRelationType the idRelationType to set
     */
    public void setIdRelationType(Integer idRelationType) {
        this.idRelationType.setId(idRelationType);
    }
    /**
     * @param idSecondPerson the idSecondPerson to set
     */
    public void setIdSecondPerson(Integer idSecondPerson) {
        this.idSecondPerson.setId(idSecondPerson);;
    }
}