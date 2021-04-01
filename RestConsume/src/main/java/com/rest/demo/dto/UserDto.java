package com.rest.demo.dto;

import lombok.Data;

@Data
public class UserDto {
	
	private String username;
	
	private LocationDto location;
}
