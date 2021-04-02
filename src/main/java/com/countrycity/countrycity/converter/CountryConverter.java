package com.countrycity.countrycity.converter;

import com.countrycity.countrycity.dto.country.CountryCreateDto;
import com.countrycity.countrycity.dto.country.CountryResponseDto;
import com.countrycity.countrycity.dto.country.CountryUpdateDto;
import com.countrycity.countrycity.entity.CountryEntity;


public class CountryConverter {

    public static CountryEntity convertCreateDtoToEntity(CountryCreateDto country) {
        return populateCountryEntity(country.getName(), country.getArea(), country.getWaterPercentage(), country.getPopulationDensity(), country.getGdp());
    }

    public static CountryResponseDto convertEntityToResponseDto(CountryEntity country) {
        CountryResponseDto response = new CountryResponseDto();
        response.setName(country.getName());
        response.setArea(country.getArea());
        response.setWaterPercentage(country.getWaterPercentage());
        response.setPopulationDensity(country.getPopulationDensity());
        response.setGdp(country.getGdp());
        response.setActive(country.getActive());
        response.setCities(country.getCities());
        response.setFlag(country.getFlag());
        response.setCapital(country.getCapital());
        response.setRegion(country.getRegion());
        response.setSubregion(country.getSubregion());
        response.setNumericCode(country.getNumericCode());
        return response;
    }

    public static CountryEntity convertUpdateDtoToEntity(CountryUpdateDto country) {
        return populateCountryEntity(country.getName(), country.getArea(), country.getWaterPercentage(), country.getPopulationDensity(), country.getGdp());
    }

    private static CountryEntity populateCountryEntity(String name, Double area, Double waterPercentage, Double populationDensity, Double gdp) {
        CountryEntity updatedCountry = new CountryEntity();
        updatedCountry.setName(name);
        updatedCountry.setArea(area);
        updatedCountry.setWaterPercentage(waterPercentage);
        updatedCountry.setPopulationDensity(populationDensity);
        updatedCountry.setGdp(gdp);
        updatedCountry.setActive(true);
        return updatedCountry;
    }


}
