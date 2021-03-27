package com.ikubinfo.books.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ikubinfo.books.converter.CategoryConverter;
import com.ikubinfo.books.dto.CategoryDto;
import com.ikubinfo.books.entity.CategoryEntity;
import com.ikubinfo.books.exception.CostumBookException;
import com.ikubinfo.books.repository.CategoryRepository;
import com.ikubinfo.books.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	CategoryRepository categoryRepository;
	
	@Override
	public List<CategoryEntity> getAllCategories() {
		
		return categoryRepository.getAllCategories();
	}

	@Override
	public CategoryEntity getCategoryById(int id) {
		
		CategoryEntity existingCategory= categoryRepository.getCategoryById(id);
		if(existingCategory==  null) {
			throw new CostumBookException("Category doesn't exist!");
		}else {
			return existingCategory;
		}
	}

	@Override
	public CategoryEntity addCategory(CategoryDto category) {
		if(category!=null) {
			if(category.getName()!=null) {
				CategoryEntity categoryToAdd = CategoryConverter.toEntity(category);
				categoryRepository.addCategory(categoryToAdd);
				return categoryToAdd;
			}else {
				throw new CostumBookException("Name is mandatory!");
			}
			}
		return null;
		
	}

	@Override
	public CategoryEntity updateCategory(CategoryDto category) {
		CategoryEntity existingCategory = categoryRepository.getCategoryById(category.getId());
		if(existingCategory!=null) {
			if(category.getName()!=null) {
				CategoryEntity categoryToUpdate = CategoryConverter.toEntity(category);
				existingCategory.setName(categoryToUpdate.getName());
				existingCategory.setActive(categoryToUpdate.isActive());
				categoryRepository.updateCategory(existingCategory);
				return existingCategory;
			}else {
				throw new CostumBookException("Name is mandatory!");
			}
		}
		return null;
		
	}

	@Override
	public void softDeleteCategory(CategoryDto category) {
		
		if (categoryRepository.getCategoryById(category.getId()) == null) {
			throw new CostumBookException("This book doesn't exists");
		} else {
			categoryRepository.softDeleteCategory(CategoryConverter.toEntity(category));
		}
		
	}

	@Override
	public void hardDeleteCategory(CategoryDto category) {
		if (categoryRepository.getCategoryById(category.getId()) == null) {
			throw new CostumBookException("This book doesn't exists");
		} else {
			categoryRepository.hardDeleteCategory(CategoryConverter.toEntity(category));
		}
		
	}

}
