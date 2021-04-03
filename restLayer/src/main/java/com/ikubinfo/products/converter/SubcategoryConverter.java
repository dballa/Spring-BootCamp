package com.ikubinfo.products.converter;

import com.ikubinfo.products.dto.SubcategoryDto;
import com.ikubinfo.products.entity.SubcategoryEntity;

public class SubcategoryConverter {
	
	public static SubcategoryDto toDto(SubcategoryEntity entity) {
		SubcategoryDto toReturn=new SubcategoryDto();
		toReturn.setId(entity.getId());
		toReturn.setName(entity.getName());
		toReturn.setActive(entity.isActive());
		return toReturn;
	}
	
	public static SubcategoryEntity toEntity (SubcategoryDto dto) {
		SubcategoryEntity toReturn=new SubcategoryEntity();
		toReturn.setId(dto.getId());
		toReturn.setName(dto.getName());
		toReturn.setActive(dto.isActive());
		return toReturn;
	}

}
