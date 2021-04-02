package com.example.SpringBootCamp.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class UserFilter {

	private String firstName;
	private String lastName;
	private Integer age;
	private String sortBy;
	private String order;
}
