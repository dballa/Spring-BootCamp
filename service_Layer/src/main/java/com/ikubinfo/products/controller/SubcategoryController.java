package com.ikubinfo.products.controller;

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

import com.ikubinfo.products.converter.SubcategoryConverter;
import com.ikubinfo.products.dto.SubcategoryDto;
import com.ikubinfo.products.entity.SubcategoryEntity;
import com.ikubinfo.products.service.SubcategoryService;

@RestController
public class SubcategoryController {
	
	@Autowired
	SubcategoryService subcategoryService;
	
	@PostMapping("/addSubcategory")
	public SubcategoryDto addCategory(@RequestBody SubcategoryDto subcategory) {
		return SubcategoryConverter.toDto(subcategoryService.addSubcategory(subcategory));
	}
	
	@PutMapping("/updateSubcategory")
	public SubcategoryDto updateSubcategory(@RequestBody SubcategoryDto subcategory) {
		return SubcategoryConverter.toDto(subcategoryService.updateSubcategory(subcategory));
	}
	
	@DeleteMapping("hardDeleteSubcategory")
	public void hardDeleteSubcategory(@RequestBody SubcategoryDto subcategory) {
		subcategoryService.hardDeleteSubcategory(subcategory);
	}
	
	@DeleteMapping("softDeleteSubcategory")
	public void softDeleteSubcategory(@RequestBody SubcategoryDto subcategory) {
		subcategoryService.softDeleteSubcategory(subcategory);
	}
	
	@GetMapping("/findSubcategory/{id}")
	public SubcategoryDto getSubcategoryById(@PathVariable int id) {
		return SubcategoryConverter.toDto(subcategoryService. getSubcategoryById(id));
	}
	
	@GetMapping("/allSubcategories")
	public List<SubcategoryDto> getAllSubcategories(){
		
		List<SubcategoryDto> subcategories = new ArrayList<>(); 
		for(SubcategoryEntity subcategory : subcategoryService. getAllSubcategories()) {
			subcategories.add(SubcategoryConverter.toDto(subcategory));
		}
		return subcategories;
	}

}
