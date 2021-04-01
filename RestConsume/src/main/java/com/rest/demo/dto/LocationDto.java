package com.rest.demo.dto;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class LocationDto {

	@NotBlank(message = "City is Mandatory !")
	private String city;

}
