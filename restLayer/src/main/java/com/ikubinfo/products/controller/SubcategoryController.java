package com.ikubinfo.products.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ikubinfo.products.converter.SubcategoryConverter;
import com.ikubinfo.products.dto.SubcategoryDto;
import com.ikubinfo.products.entity.SubcategoryEntity;
import com.ikubinfo.products.service.SubcategoryService;

@RestController
public class SubcategoryController {
	
	@Autowired
	SubcategoryService subcategoryService;
	
	//create new subcategory
	@PostMapping("/subcategories")
	public ResponseEntity<SubcategoryDto> addSubcategory(@Valid @RequestBody SubcategoryDto subcategory) {
		return new ResponseEntity<>(SubcategoryConverter.toDto(subcategoryService.addSubcategory(subcategory)),HttpStatus.CREATED);
	}
	//update subcategory
	@PutMapping("/subcategories")
	public ResponseEntity<SubcategoryDto> updateSubcategory(@Valid @RequestBody SubcategoryDto subcategory) {
		return new ResponseEntity<>(SubcategoryConverter.toDto(subcategoryService.updateSubcategory(subcategory)),HttpStatus.CREATED);
	}
	//hard delete subcategories
	@DeleteMapping("/subcategories")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void hardDeleteSubcategory(@RequestBody SubcategoryDto subcategory) {
		subcategoryService.hardDeleteSubcategory(subcategory);
		
	}
	//soft delete subcategories
	@DeleteMapping("softDeleteSubcategory")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void softDeleteSubcategory(@RequestBody SubcategoryDto subcategory) {
		subcategoryService.softDeleteSubcategory(subcategory);
	}
	//get subcategories by id
	@GetMapping("/subcategories/{id}")
	public ResponseEntity<SubcategoryDto> getSubcategoryById(@PathVariable int id) {
		return new ResponseEntity<>(SubcategoryConverter.toDto(subcategoryService. getSubcategoryById(id)), HttpStatus.OK);
	}
	//get all subcategories
	@GetMapping("/subcategories")
	public ResponseEntity<List<SubcategoryDto>> getAllSubcategories(){
		
		List<SubcategoryDto> subcategories = new ArrayList<>(); 
		for(SubcategoryEntity subcategory : subcategoryService. getAllSubcategories()) {
			subcategories.add(SubcategoryConverter.toDto(subcategory));
		}
		return new ResponseEntity<>(subcategories, HttpStatus.OK);
	}

}
