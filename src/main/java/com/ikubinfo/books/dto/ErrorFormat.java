package com.ikubinfo.books.dto;

import java.util.Date;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorFormat {
	
	private String message;
	private Date timeStamp=new Date(); 

}
