package com.example.SpringBootCamp.demo.converter;


import com.example.SpringBootCamp.demo.dto.CheckInDto;
import com.example.SpringBootCamp.demo.entity.CheckInEntity;

public class CheckInConverter {
    public static CheckInDto toDto(CheckInEntity checkInEntity){
        CheckInDto toReturn=new CheckInDto();
        toReturn.setId(checkInEntity.getId());
        toReturn.setTimes(checkInEntity.getTimes());
        toReturn.setCount(checkInEntity.getCount());
        return toReturn;

    }
    public static CheckInEntity toEntity(CheckInDto checkInDto){
        CheckInEntity toReturn=new CheckInEntity();
        toReturn.setId(checkInDto.getId());
        toReturn.setTimes(checkInDto.getTimes());
        toReturn.setCount(checkInDto.getCount());
        return toReturn;
    }
}
