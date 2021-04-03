package com.ikubinfo.books.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ikubinfo.books.converter.CategoryConverter;
import com.ikubinfo.books.dto.CategoryDto;
import com.ikubinfo.books.entity.CategoryEntity;
import com.ikubinfo.books.service.CategoryService;

@RestController
public class CategoryController {
	
	@Autowired
	CategoryService categoryService;
	
	@PostMapping("/addCategory")
	public CategoryDto addCategory(@RequestBody CategoryDto category) {
		
		return CategoryConverter.toDto(categoryService.addCategory(category));
	}
	@PutMapping("/updateCategory")
	public CategoryDto updateCategory(@RequestBody CategoryDto category) {
		return CategoryConverter.toDto(categoryService.updateCategory(category));
	}
	@DeleteMapping("hardDeleteCategory")
	public void hardDeleteUser(@RequestBody CategoryDto category) {

		categoryService.hardDeleteCategory(category);
	}
	@DeleteMapping("softDeleteCategory")
	public void softDeleteUser(@RequestBody CategoryDto category) {

		categoryService.softDeleteCategory(category);
	}
	@GetMapping("/findCategory/{id}")
	public CategoryDto getCategoryById(@PathVariable int id) {

		return CategoryConverter.toDto(categoryService. getCategoryById(id));
	}
	@GetMapping("/allCategories")
	public List<CategoryDto> getAllCategorys(){
		
		List<CategoryDto> categories = new ArrayList<>(); 
		for(CategoryEntity category : categoryService. getAllCategories()) {
			categories.add(CategoryConverter.toDto(category));
		}
		return categories;
	}

}
