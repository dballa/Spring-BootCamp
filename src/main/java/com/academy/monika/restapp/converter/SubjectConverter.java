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
        toReturn.setActive(entity.isActive());
        toReturn.setCreditsCfu(entity.getCreditsCfu());
        toReturn.setProfessor(entity.getProfessor());
        toReturn.setSemester(entity.getSemester());
        return toReturn;
    }

    public static SubjectEntity toEntity (SubjectDto dto) {
        SubjectEntity toReturn=new SubjectEntity();
        toReturn.setId(dto.getId());
        toReturn.setName(dto.getName());
        toReturn.setActive(dto.isActive());
        toReturn.setCreditsCfu(dto.getCreditsCfu());
        toReturn.setProfessor(dto.getProfessor());
        toReturn.setSemester(dto.getSemester());
        return toReturn;
    }
    public static SubjectDtoForCreate toEntityForCreate(SubjectDtoForCreate dto, ProfessorEntity professorEntity) {
        SubjectDtoForCreate toReturn=new SubjectDtoForCreate();
        toReturn.setName(dto.getName());
        toReturn.setActive(dto.getActive());
        toReturn.setCreditsCfu(dto.getCreditsCfu());
        toReturn.setProfessorId(professorEntity.getId());
        toReturn.setSemester(dto.getSemester());
        return toReturn;
    }
}
