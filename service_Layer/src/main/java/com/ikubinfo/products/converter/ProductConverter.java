package com.ikubinfo.products.converter;

import com.ikubinfo.products.dto.ProductDto;
import com.ikubinfo.products.dto.ProductDtoForCreate;
import com.ikubinfo.products.entity.ProductEntity;
import com.ikubinfo.products.entity.SubcategoryEntity;

public class ProductConverter {
	
	public static ProductDto toDto(ProductEntity entity) {
		ProductDto toReturn = new ProductDto();
		toReturn.setId(entity.getId());
		toReturn.setName(entity.getName());
		toReturn.setDescription(entity.getDescription());
		toReturn.setPrice(entity.getPrice());
		toReturn.setSubcategory(SubcategoryConverter.toDto(entity.getSubcategory()));
		return toReturn;
	}

	public static ProductEntity toEntity(ProductDto dto) {
		ProductEntity toReturn=new ProductEntity();
		toReturn.setId(dto.getId());
		toReturn.setName(dto.getName());
		toReturn.setDescription(dto.getDescription());
		toReturn.setPrice(dto.getPrice());
		toReturn.setSubcategory(SubcategoryConverter.toEntity(dto.getSubcategory()));
		return toReturn;
	}
	public static ProductEntity toEntityForCreate(ProductDtoForCreate dto, SubcategoryEntity catEntity) {
		ProductEntity toReturn=new ProductEntity();
		toReturn.setId(dto.getId());
		toReturn.setName(dto.getName());
		toReturn.setDescription(dto.getDescription());
		toReturn.setPrice(dto.getPrice());
		toReturn.setSubcategory(catEntity);
		return toReturn;
	}

}
