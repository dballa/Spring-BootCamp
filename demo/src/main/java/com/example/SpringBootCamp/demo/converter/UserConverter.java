package com.example.SpringBootCamp.demo.converter;

import com.example.SpringBootCamp.demo.dto.UserDto;
import com.example.SpringBootCamp.demo.dto.UserDtoForCreate;
import com.example.SpringBootCamp.demo.entity.SubscriptionEntity;
import com.example.SpringBootCamp.demo.entity.UserEntity;

public class UserConverter {

	//private SubscriptionConverter subscriptionConverter = new SubscriptionConverter();

	public static UserDto toDto(UserEntity entity) {
		UserDto toReturn = new UserDto();
		toReturn.setId(entity.getId());
		toReturn.setAge(entity.getAge());
		toReturn.setFirstName(entity.getFirstName());
		toReturn.setLastName(entity.getLastName());
		toReturn.setSubscription(SubscriptionConverter.toDto(entity.getSubscription()));
		return toReturn;
	}

	public static UserEntity toEntity(UserDto dto) {
		UserEntity toReturn=new UserEntity();
		toReturn.setFirstName(dto.getFirstName());
		toReturn.setLastName(dto.getLastName());
		toReturn.setAge(dto.getAge());
		toReturn.setId(dto.getId());
		toReturn.setSubscription(SubscriptionConverter.toEntity(dto.getSubscription()));
		return toReturn;
	}
	public static UserEntity toEntityForCreate(UserDtoForCreate dto, SubscriptionEntity subEntity) {
		UserEntity toReturn=new UserEntity();
		toReturn.setFirstName(dto.getFirstName());
		toReturn.setLastName(dto.getLastName());
		toReturn.setAge(dto.getAge());
		toReturn.setSubscription(subEntity);
		return toReturn;
	}
}
