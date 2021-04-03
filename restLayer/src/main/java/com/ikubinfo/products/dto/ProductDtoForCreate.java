package com.ikubinfo.products.dto;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class ProductDtoForCreate {

	private int id;
	
	@NotBlank(message="Name is mandatory")
	private String name;
	
	private String description;
	
	@NotNull(message="Price is mandatory")
	private int price;
	
	
	


	private int subcategory;
}
