package com.ikubinfo.books.dto;

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
	
	private String isbn;
	
	private String title;
	
	private String description;
	
	private int numberOfPages;
	
	private String publisher;
	
	private int edition;
	
	private int category;
}
