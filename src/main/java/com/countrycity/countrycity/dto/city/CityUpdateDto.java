package com.countrycity.countrycity.dto.city;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CityUpdateDto {

    private Long id;
    private String name;
    private Double area;
    private Double populationDensity;
    private String postalCode;
    private Long countryId;

}
