package com.academy.monika.restapp.converter;

import com.academy.monika.restapp.dto.ProfessorDto;
import com.academy.monika.restapp.entity.ProfessorEntity;

public class ProfessorConverter {

    public static ProfessorDto toDto(ProfessorEntity entity) {
        ProfessorDto toReturn=new ProfessorDto();
        toReturn.setId(entity.getId());
        toReturn.setFirstName(entity.getFirstName());
        toReturn.setLastName(entity.getLastName());
        return toReturn;
    }

    public static ProfessorEntity toEntity (ProfessorDto dto) {
        ProfessorEntity toReturn=new ProfessorEntity();
        toReturn.setId(dto.getId());
        toReturn.setFirstName(dto.getFirstName());
        toReturn.setLastName(dto.getLastName());
        return toReturn;
    }
}
