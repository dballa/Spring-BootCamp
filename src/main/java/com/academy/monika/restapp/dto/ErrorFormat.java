package com.academy.monika.restapp.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class ErrorFormat {
	private String message;
	private Date timeStamp=new Date();
	private String suggestion;
}
