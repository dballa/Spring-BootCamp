package com.example.SpringBootCamp.demo.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ResponseTestExternalAPI {

    private int userId;
    private int id;
    private String title;
    private boolean completed;
}
