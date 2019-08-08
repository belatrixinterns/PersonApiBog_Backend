package com.person.api.converter;

import com.person.api.dto.RelationshipDto;
import com.person.api.entity.RelationshipEntity;

/**
 * RelationshipConverter
 */
public class RelationshipConverter {

    public static RelationshipDto convertToDto(RelationshipEntity relationshipEntity){
        return new RelationshipDto(relationshipEntity.getIdFirstPerson(), relationshipEntity.getIdSecondPerson(), relationshipEntity.getIdRelationType());
    }

    public static RelationshipEntity convertToEntity(RelationshipDto relationshipDto){
        return new RelationshipEntity(relationshipDto.getIdFirstPerson(), relationshipDto.getIdSecondPerson(), relationshipDto.getIdRelationType());
    }
}