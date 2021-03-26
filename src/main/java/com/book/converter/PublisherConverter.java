package com.book.converter;

import com.book.Entity.PublisherEntity;
import com.book.dto.PublisherDto;

public class PublisherConverter {
	
	public static PublisherDto toDto(PublisherEntity entity) {
		PublisherDto toReturn=new PublisherDto();
		toReturn.setId(entity.getId());
		toReturn.setName(entity.getName());
		toReturn.setAddress(entity.getAddress());
		return toReturn;
	}
	
	public static PublisherEntity toEntity (PublisherDto dto) {
		PublisherEntity toReturn=new PublisherEntity();
		toReturn.setId(dto.getId());
		toReturn.setName(dto.getName());
		toReturn.setAddress(dto.getAddress());
		return toReturn;
	}
	
}

