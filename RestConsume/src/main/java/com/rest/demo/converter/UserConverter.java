package com.rest.demo.converter;

import java.util.ArrayList;
import java.util.List;

import com.rest.demo.dto.UserDto;
import com.rest.demo.dto.UserDtoCreate;
import com.rest.demo.entity.LocationEntity;
import com.rest.demo.entity.UserEntity;


public class UserConverter {
	
	private UserConverter() {}
	
	public static UserDto toDto(UserEntity entity) {
		UserDto toReturn = new UserDto();
		toReturn.setUsername(entity.getUsername());
		toReturn.setLocation(LocationConverter.toDto(entity.getLocation()));
		return toReturn;
	}
	
	public static List<UserDto> toDto(List<UserEntity> entity) {
		List<UserDto> toReturn = new ArrayList<>();
		for(UserEntity ue : entity) {
			toReturn.add(toDto(ue));
		}
		return toReturn;
	}

	public static UserEntity toEntityForCreate(UserDtoCreate dto, LocationEntity location) {
		UserEntity toReturn=new UserEntity();
		toReturn.setUserId(null);
		toReturn.setUsername(dto.getUsername());
		toReturn.setPassword(dto.getPassword());
		toReturn.setLocation(location);
		return toReturn;
	}
}
