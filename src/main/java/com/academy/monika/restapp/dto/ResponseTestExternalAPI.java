package com.academy.monika.restapp.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class ResponseTestExternalAPI {

	private String  status;
	private List<EmployeeDto> data;
}
