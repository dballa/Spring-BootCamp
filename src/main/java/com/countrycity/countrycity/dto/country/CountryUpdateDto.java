package com.countrycity.countrycity.dto.country;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CountryUpdateDto {

    private String name;
    private Double area;
    private Double waterPercentage;
    private Double populationDensity;
    private Double gdp;

}
