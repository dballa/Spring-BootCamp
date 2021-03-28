package com.ikubinfo.products.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ikubinfo.products.converter.SubcategoryConverter;
import com.ikubinfo.products.dto.SubcategoryDto;
import com.ikubinfo.products.entity.SubcategoryEntity;
import com.ikubinfo.products.exception.ProductException;
import com.ikubinfo.products.repository.SubcategoryRepository;
import com.ikubinfo.products.service.SubcategoryService;

@Service
public class SubcategoryServiceImpl implements SubcategoryService {

	@Autowired
	SubcategoryRepository subcategoryRepository;
	
	@Override
	public List<SubcategoryEntity> getAllSubcategories() {
		
		return subcategoryRepository.getAllSubcategories();
	}

	@Override
	public SubcategoryEntity getSubcategoryById(int id) {
		
		SubcategoryEntity existingSubcategory= subcategoryRepository.getSubcategoryById(id);
		if(existingSubcategory==  null) {
			throw new ProductException("Subcategory doesn't exist!");
		}else {
			return existingSubcategory;
		}
	}

	@Override
	public SubcategoryEntity addSubcategory(SubcategoryDto subcategory) {
		if(subcategory!=null) {
			if(subcategory.getName()!=null) {
				SubcategoryEntity subcategoryToAdd = SubcategoryConverter.toEntity(subcategory);
				subcategoryRepository.addSubcategory(subcategoryToAdd);
				return subcategoryToAdd;
			}else {
				throw new ProductException("Name is mandatory!");
			}
			}
		return null;
		
	}

	@Override
	public SubcategoryEntity updateSubcategory(SubcategoryDto subcategory) {
		SubcategoryEntity existingSubcategory = subcategoryRepository.getSubcategoryById(subcategory.getId());
		if(existingSubcategory!=null) {
			if(subcategory.getName()!=null) {
				SubcategoryEntity subcategoryToUpdate = SubcategoryConverter.toEntity(subcategory);
				existingSubcategory.setName(subcategoryToUpdate.getName());
				existingSubcategory.setActive(subcategoryToUpdate.isActive());
				subcategoryRepository.updateSubcategory(existingSubcategory);
				return existingSubcategory;
			}else {
				throw new ProductException("Name is mandatory!");
			}
		}
		return null;
		
	}

	@Override
	public void softDeleteSubcategory(SubcategoryDto subcategory) {
		
		if (subcategoryRepository.getSubcategoryById(subcategory.getId()) == null) {
			throw new ProductException("This product doesn't exists");
		} else {
			subcategoryRepository.softDeleteSubcategory(SubcategoryConverter.toEntity(subcategory));
		}
		
	}

	@Override
	public void hardDeleteSubcategory(SubcategoryDto subcategory) {
		if (subcategoryRepository.getSubcategoryById(subcategory.getId()) == null) {
			throw new ProductException("This product doesn't exists");
		} else {
			subcategoryRepository.hardDeleteSubcategory(SubcategoryConverter.toEntity(subcategory));
		}
		
	}

}
