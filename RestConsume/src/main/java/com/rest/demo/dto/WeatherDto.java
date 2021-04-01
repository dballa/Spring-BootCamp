package com.rest.demo.dto;

import lombok.Data;

@Data
public class WeatherDto {
   
    private String description;
   
    private int tempMin;
    
    private int tempMax;

    private int windSpeed;
    
    private String country;
}
