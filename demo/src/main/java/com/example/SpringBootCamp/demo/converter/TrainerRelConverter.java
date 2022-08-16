package com.example.SpringBootCamp.demo.converter;

import com.example.SpringBootCamp.demo.dto.TrainerRelDto;
import com.example.SpringBootCamp.demo.entity.TrainerRelEntity;


public class TrainerRelConverter {
    public  static TrainerRelDto toDto(TrainerRelEntity trainerRel){
        TrainerRelDto toReturn=new TrainerRelDto();
        toReturn.setId(trainerRel.getId());
        toReturn.setUserId(trainerRel.getUser());
        toReturn.setTrainerId(trainerRel.getTrainer());
        return toReturn;
    }
    public static TrainerRelEntity toEntity(TrainerRelDto trainerDto){
        TrainerRelEntity toReturn=new TrainerRelEntity();
        toReturn.setId(trainerDto.getId());
        toReturn.setUser(trainerDto.getUserId());
        toReturn.setTrainer(trainerDto.getTrainerId());
        return  toReturn;
    }
}
