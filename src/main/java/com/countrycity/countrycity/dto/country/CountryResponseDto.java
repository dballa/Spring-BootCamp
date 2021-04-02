package com.countrycity.countrycity.dto.country;

import com.countrycity.countrycity.entity.CityEntity;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CountryResponseDto {

    private String name;
    private Double area;
    private Double waterPercentage;
    private Double populationDensity;
    private Double gdp;
    private Boolean active;
    private List<CityEntity> cities;
    private String flag;
    private String capital;
    private String region;
    private String subregion;
    private String numericCode;

}
