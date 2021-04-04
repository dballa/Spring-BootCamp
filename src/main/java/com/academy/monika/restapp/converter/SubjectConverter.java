package com.academy.monika.restapp.converter;


import com.academy.monika.restapp.dto.SubjectDto;
import com.academy.monika.restapp.dto.SubjectDtoForCreate;
import com.academy.monika.restapp.entity.ProfessorEntity;
import com.academy.monika.restapp.entity.SubjectEntity;

public class SubjectConverter {
    public static SubjectDto toDto(SubjectEntity entity) {
        SubjectDto toReturn=new SubjectDto();
        toReturn.setId(entity.getId());
        toReturn.setName(entity.getName());
        toReturn.setActive(entity.getActive());
        toReturn.setCreditsCfu(entity.getCreditsCfu());
        toReturn.setProfessor(entity.getProfessor());
        toReturn.setSemester(entity.getSemester());
        return toReturn;
    }
}
