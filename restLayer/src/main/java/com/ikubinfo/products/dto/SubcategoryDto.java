package com.ikubinfo.products.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class SubcategoryDto {
	
	private int id;
	
	private String name;

	private boolean active;

	
}
