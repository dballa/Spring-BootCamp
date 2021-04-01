package com.rest.demo.dto;

import java.util.Date;

import lombok.Data;

@Data
public class ErrorFormat {
	
	private String message;
	private Date timeStamp=new Date(); 
	private String path;
	private String suggestion;

}
