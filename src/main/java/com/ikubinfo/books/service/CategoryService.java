package com.ikubinfo.books.service;

import java.util.List;

import com.ikubinfo.books.dto.CategoryDto;
import com.ikubinfo.books.entity.CategoryEntity;

public interface CategoryService {
	
	public List<CategoryEntity> getAllCategories();
	
	public CategoryEntity getCategoryById(int id);
	
	public CategoryEntity addCategory(CategoryDto category);
	
	public CategoryEntity updateCategory(CategoryDto category);
	
	public void softDeleteCategory(CategoryDto category);
	
	public void hardDeleteCategory(CategoryDto category);

}
