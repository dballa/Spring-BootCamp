package com.example.SpringBootCamp.demo.converter;

import com.example.SpringBootCamp.demo.dto.UserDto;
import com.example.SpringBootCamp.demo.entity.UserEntity;

public class UserConverter {

	private SubscriptionConverter subscriptionConverter = new SubscriptionConverter();

	public UserDto toDto(UserEntity entity) {
		UserDto toReturn = new UserDto();
		toReturn.setId(entity.getId());
		toReturn.setAge(entity.getAge());
		toReturn.setFirstName(entity.getFirstName());
		toReturn.setLastName(entity.getLastName());
		toReturn.setSubscription(subscriptionConverter.toDto(entity.getSubscription()));
		return toReturn;
	}

	public UserEntity toEntity(UserDto dto) {
		UserEntity toReturn=new UserEntity();
		toReturn.setFirstName(dto.getFirstName());
		toReturn.setLastName(dto.getLastName());
		toReturn.setAge(dto.getAge());
		toReturn.setId(dto.getId());
		toReturn.setSubscription(subscriptionConverter.toEntity(dto.getSubscription()));
		return toReturn;
	}
}
