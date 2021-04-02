package com.countrycity.countrycity.dto.city;

import com.countrycity.countrycity.entity.CountryEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CityResponseDto {

    private String name;
    private Double area;
    private Double populationDensity;
    private String postalCode;
    private String country;

}
