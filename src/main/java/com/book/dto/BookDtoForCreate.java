package com.book.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@NoArgsConstructor
@ToString

public class BookDtoForCreate {

	private String name;

	private int price;
	
	private int rate;
	
	private long publisher_id;

	
}
