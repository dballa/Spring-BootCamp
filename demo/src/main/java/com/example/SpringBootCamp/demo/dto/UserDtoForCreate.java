package com.example.SpringBootCamp.demo.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class UserDtoForCreate {
	private Long id;

	private String firstName;

	private String lastName;

	private int age;

	private long subscription;
}
