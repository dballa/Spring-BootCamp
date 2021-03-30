package com.example.SpringBootCamp.demo.dto;

import javax.validation.constraints.Min;
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
public class UserDtoForCreate {
	private Long id;
	@NotBlank(message="First name is mandatory")
	private String firstName;
	@NotNull(message="Last name is mandatory")
	private String lastName;
	//Nese vleren do e kishim statike 
	@Min(value=10, message="Minimal age to add user is 10")
	private int age;

	private long subscription;
}
