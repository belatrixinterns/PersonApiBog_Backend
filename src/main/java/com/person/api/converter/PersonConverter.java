package com.person.api.converter;

import com.person.api.dto.PersonDto;
import com.person.api.entity.PersonEntity;

/**
 * UsuarioConverter
 */
public class PersonConverter {

    public static PersonDto convertToDto(PersonEntity usuarioEntity){
        return new PersonDto(usuarioEntity.getDocument_id(), usuarioEntity.getName(), usuarioEntity.getLast_name(),
         usuarioEntity.getDate_of_birth(), usuarioEntity.getDocument_type(), usuarioEntity.getGender(), usuarioEntity.getNationality(), usuarioEntity.getContact());
    }

    public static PersonEntity convertToEntity(PersonDto usuarioDto){
        return new PersonEntity(null, usuarioDto.getDocument_id(), usuarioDto.getName(), usuarioDto.getLast_name(),
         usuarioDto.getDate_of_birth(), usuarioDto.getDocument_type(), usuarioDto.getGender(), usuarioDto.getNationality(), usuarioDto.getContact());
    }
}