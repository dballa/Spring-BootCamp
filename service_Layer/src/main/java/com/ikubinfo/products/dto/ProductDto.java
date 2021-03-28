package com.ikubinfo.products.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class ProductDto {
	
	private int id;
	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public int getPrice() {
		return price;
	}


	public void setPrice(int price) {
		this.price = price;
	}


	public SubcategoryDto getSubcategory() {
		return subcategory;
	}


	public void setSubcategory(SubcategoryDto subcategory) {
		this.subcategory = subcategory;
	}


	private String name;
	
	private String description;
	
	private int price;
	
	
	private SubcategoryDto subcategory;

}
