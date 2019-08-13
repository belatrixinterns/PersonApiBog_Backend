package com.person.api.converter;

import com.person.api.dto.RelationshipDto;
import com.person.api.entity.RelationshipEntity;

/**
 * RelationshipConverter
 */
public class RelationshipConverter {

    public static RelationshipDto convertToDto(RelationshipEntity relationshipEntity){
        return new RelationshipDto(relationshipEntity.getIdFirstPerson().toString(), relationshipEntity.getIdSecondPerson().toString(), relationshipEntity.getIdRelationType().toString());
    }

    public static RelationshipEntity convertToEntity(RelationshipDto relationshipDto){
        return new RelationshipEntity(Integer.parseInt(relationshipDto.getIdFirstPerson()), Integer.parseInt(relationshipDto.getIdSecondPerson()), Integer.parseInt(relationshipDto.getIdRelationType()));
    }
}