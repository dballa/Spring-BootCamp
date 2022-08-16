package com.example.SpringBootCamp.demo.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
public class ErrorFormat {
    private String message;
    private Date timeStamp=new Date();
    private String path;
    private String suggestion;
}
