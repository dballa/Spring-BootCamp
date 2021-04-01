package com.rest.demo.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class UserDtoCreate {
	
	@NotBlank(message = "Username is mandatory !")
	private String username;

	@NotBlank(message = "Password is mandatory !")
	private String password;
	
	@NotNull(message = "Location Id is mandatory !")
	private int location;

}
