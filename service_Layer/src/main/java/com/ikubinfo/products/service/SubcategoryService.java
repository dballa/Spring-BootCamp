package com.ikubinfo.products.service;

import java.util.List;

import com.ikubinfo.products.dto.SubcategoryDto;
import com.ikubinfo.products.entity.SubcategoryEntity;

public interface SubcategoryService {
	
	public List<SubcategoryEntity> getAllSubcategories();
	
	public SubcategoryEntity getSubcategoryById(int id);
	
	public SubcategoryEntity addSubcategory(SubcategoryDto subcategory);
	
	public SubcategoryEntity updateSubcategory(SubcategoryDto subcategory);
	
	public void softDeleteSubcategory(SubcategoryDto subcategory);
	
	public void hardDeleteSubcategory(SubcategoryDto subcategory);

}
