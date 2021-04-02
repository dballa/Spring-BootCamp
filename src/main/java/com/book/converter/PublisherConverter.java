package com.book.converter;

import com.book.dto.PublisherDto;
import com.book.dto.PublisherDtoForCreate;
import com.book.dto.PublisherDtoForUpdate;
import com.book.entity.PublisherEntity;

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
	
	public static PublisherEntity toEntityForCreate(PublisherDtoForCreate dto) {
		PublisherEntity toReturn=new PublisherEntity();
		toReturn.setName(dto.getName());
		toReturn.setAddress(dto.getAddress());
		return toReturn;
	}
	public static PublisherEntity toEntityForUpdate(PublisherDtoForUpdate dto) {
		PublisherEntity toReturn=new PublisherEntity();
		toReturn.setName(dto.getName());
		toReturn.setAddress(dto.getAddress());
		return toReturn;
	}
	
}

