package com.example.SpringBootCamp.demo.converter;

import com.example.SpringBootCamp.demo.dto.UserDto;
import com.example.SpringBootCamp.demo.entity.UserEntity;


public class UserConverter {
    public static UserDto toDto(UserEntity entity) {
        UserDto toReturn = new UserDto();
        toReturn.setUserId(entity.getUserId());
        toReturn.setFirstName(entity.getFirstName());
        toReturn.setLastName(entity.getLastName());
        toReturn.setGender(entity.getGender());
        toReturn.setRole(entity.getRole());
        toReturn.setAge(entity.getAge());
        toReturn.setMembershipId(entity.getMembershipId());

        return toReturn;
    }
    public static UserEntity toEntity(UserDto dto){
        UserEntity toReturn=new UserEntity();
        toReturn.setUserId(dto.getUserId());
        toReturn.setFirstName(dto.getFirstName());
        toReturn.setLastName(dto.getLastName());
        toReturn.setRole(dto.getRole());
        toReturn.setAge(dto.getAge());
        toReturn.setMembershipId(dto.getMembershipId());
        return  toReturn;
    }

}
