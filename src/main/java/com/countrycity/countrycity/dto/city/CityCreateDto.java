package com.countrycity.countrycity.dto.city;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CityCreateDto {

    private String name;
    private Double area;
    private Double populationDensity;
    private String postalCode;
    private Long countryId;

}
