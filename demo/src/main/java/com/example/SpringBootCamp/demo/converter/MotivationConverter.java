package com.example.SpringBootCamp.demo.converter;


import com.example.SpringBootCamp.demo.dto.MotivationDto;
import com.example.SpringBootCamp.demo.entity.MotivationEntity;

public class MotivationConverter {
    public static MotivationDto toDto(MotivationEntity motivationEntity){
        MotivationDto toReturn=new MotivationDto();
        toReturn.setId(motivationEntity.getId());
        toReturn.setMotivationQuote(motivationEntity.getMotivationQuote());
       // toReturn.setCreatedBy(motivationEntity.getCreatedBy());
        return toReturn;
    }
public static MotivationEntity toEntity(MotivationDto motivationDto){
        MotivationEntity toReturn=new MotivationEntity();
    toReturn.setId(motivationDto.getId());
    toReturn.setMotivationQuote(motivationDto.getMotivationQuote());
  //  toReturn.setCreatedBy(motivationDto.getCreatedBy());
    return toReturn;
}
}
