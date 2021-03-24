package com.example.SpringBootCamp.demo.converter;

import com.example.SpringBootCamp.demo.dto.SubscriptionDto;
import com.example.SpringBootCamp.demo.entity.SubscriptionEntity;

public class SubscriptionConverter {

	
	public SubscriptionDto toDto(SubscriptionEntity entity) {
		SubscriptionDto toReturn=new SubscriptionDto();
		toReturn.setId(entity.getId());
		toReturn.setName(entity.getName());
		toReturn.setActive(entity.isActive());
		return toReturn;
	}
	
	public SubscriptionEntity toEntity (SubscriptionDto dto) {
		SubscriptionEntity toReturn=new SubscriptionEntity();
		toReturn.setId(dto.getId());
		toReturn.setName(dto.getName());
		toReturn.setActive(dto.isActive());
		return toReturn;
	}
}
