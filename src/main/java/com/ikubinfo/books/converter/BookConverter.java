package com.ikubinfo.books.converter;

import com.ikubinfo.books.dto.BookDto;
import com.ikubinfo.books.dto.BookDtoForCreate;
import com.ikubinfo.books.entity.BookEntity;
import com.ikubinfo.books.entity.CategoryEntity;

public class BookConverter {
	
	public static BookDto toDto(BookEntity entity) {
		BookDto toReturn = new BookDto();
		toReturn.setId(entity.getId());
		toReturn.setIsbn(entity.getIsbn());
		toReturn.setTitle(entity.getTitle());
		toReturn.setDescription(entity.getDescription());
		toReturn.setNumberOfPages(entity.getNumberOfPages());
		toReturn.setEdition(entity.getEdition());
		toReturn.setPublisher(entity.getPublisher());
		toReturn.setCategory(CategoryConverter.toDto(entity.getCategory()));
		return toReturn;
	}

	public static BookEntity toEntity(BookDto dto) {
		BookEntity toReturn=new BookEntity();
		toReturn.setId(dto.getId());
		toReturn.setIsbn(dto.getIsbn());
		toReturn.setTitle(dto.getTitle());
		toReturn.setDescription(dto.getDescription());
		toReturn.setNumberOfPages(dto.getNumberOfPages());
		toReturn.setEdition(dto.getEdition());
		toReturn.setPublisher(dto.getPublisher());
		toReturn.setCategory(CategoryConverter.toEntity(dto.getCategory()));
		return toReturn;
	}
	public static BookEntity toEntityForCreate(BookDtoForCreate dto, CategoryEntity catEntity) {
		BookEntity toReturn=new BookEntity();
		toReturn.setId(dto.getId());
		toReturn.setIsbn(dto.getIsbn());
		toReturn.setTitle(dto.getTitle());
		toReturn.setDescription(dto.getDescription());
		toReturn.setNumberOfPages(dto.getNumberOfPages());
		toReturn.setEdition(dto.getEdition());
		toReturn.setPublisher(dto.getPublisher());
		toReturn.setCategory(catEntity);
		return toReturn;
	}

}
