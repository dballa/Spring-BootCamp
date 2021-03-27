package com.ikubinfo.books.converter;

import com.ikubinfo.books.dto.CategoryDto;
import com.ikubinfo.books.entity.CategoryEntity;

public class CategoryConverter {
	
	public static CategoryDto toDto(CategoryEntity entity) {
		CategoryDto toReturn=new CategoryDto();
		toReturn.setId(entity.getId());
		toReturn.setName(entity.getName());
		toReturn.setActive(entity.isActive());
		return toReturn;
	}
	
	public static CategoryEntity toEntity (CategoryDto dto) {
		CategoryEntity toReturn=new CategoryEntity();
		toReturn.setId(dto.getId());
		toReturn.setName(dto.getName());
		toReturn.setActive(dto.isActive());
		return toReturn;
	}

}
