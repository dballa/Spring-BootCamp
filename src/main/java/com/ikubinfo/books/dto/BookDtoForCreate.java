package com.ikubinfo.books.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import lombok.Getter; 
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class BookDtoForCreate {

	private int id;
	
	@NotNull(message="ISBN is mandatory")
	private String isbn;
	
	@NotNull(message="Title is mandatory")
	private String title;
	
	@NotNull(message="Description is mandatory")
	private String description;

	@Min(value=0,message="Number of pages is mandatory")
	private int numberOfPages;
	
	@NotNull(message="Publisher is mandatory")
	private String publisher;
	
	@Min(value=0,message="Edition is mandatory")
	private int edition;
	
	private int category;
}
