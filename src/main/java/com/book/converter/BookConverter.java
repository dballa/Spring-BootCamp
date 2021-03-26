package com.book.converter;

import com.book.Entity.BookEntity;
import com.book.Entity.PublisherEntity;
import com.book.dto.BookDto;
import com.book.dto.BookDtoForCreate;

public class BookConverter {
	
	public static BookDto toDto(BookEntity entity) {
		BookDto toReturn = new BookDto();
		toReturn.setId(entity.getId());
		toReturn.setName(entity.getName());
		toReturn.setPrice(entity.getPrice());
		toReturn.setRate(entity.getRate());
		toReturn.setPublisher(PublisherConverter.toDto(entity.getPublisher()));
		return toReturn;
	}

	public static BookEntity toEntity(BookDto dto) {
		BookEntity toReturn=new BookEntity();
		toReturn.setId(dto.getId());
		toReturn.setName(dto.getName());
		toReturn.setPrice(dto.getPrice());
		toReturn.setRate(dto.getRate());
		toReturn.setPublisher(PublisherConverter.toEntity(dto.getPublisher()));
		return toReturn;
	}
	public static BookEntity toEntityForCreate(BookDtoForCreate dto, PublisherEntity pubEntity) {
		BookEntity toReturn=new BookEntity();
		toReturn.setName(dto.getName());
		toReturn.setPrice(dto.getPrice());
		toReturn.setRate(dto.getRate());
		toReturn.setPublisher(pubEntity);
		return toReturn;
	}
}
