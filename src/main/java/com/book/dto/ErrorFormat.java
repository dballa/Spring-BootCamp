package com.book.dto;


import java.util.Date;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@ToString
public class ErrorFormat {
	
	private String message;
	private Date timeStamp=new Date(); 
	private String suggestion;

}

