package com.example.SpringBootCamp.demo.converter;

import com.example.SpringBootCamp.demo.dto.TrainerDto;
import com.example.SpringBootCamp.demo.entity.TrainerEntity;


public class TrainerConverter {
    public static TrainerDto toDto(TrainerEntity trainerEntity){
        TrainerDto toReturn=new TrainerDto();
        toReturn.setId(trainerEntity.getId());
        toReturn.setFirstName(trainerEntity.getFirstName());
        toReturn.setLastName(trainerEntity.getLastName());
        toReturn.setRole(trainerEntity.getRole());
        toReturn.setCount(trainerEntity.getCount());
        return toReturn;
    }
    public static TrainerEntity toEntity(TrainerDto trainerDto){
        TrainerEntity toReturn=new TrainerEntity();
        toReturn.setId(trainerDto.getId());
        toReturn.setFirstName(trainerDto.getFirstName());
        toReturn.setLastName(trainerDto.getLastName());
        toReturn.setRole(trainerDto.getRole());
        toReturn.setCount(trainerDto.getCount());
        return toReturn;
    }
}
