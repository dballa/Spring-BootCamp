package com.countrycity.countrycity.converter;

import com.countrycity.countrycity.dto.city.CityCreateDto;
import com.countrycity.countrycity.dto.city.CityResponseDto;
import com.countrycity.countrycity.dto.city.CityUpdateDto;
import com.countrycity.countrycity.entity.CityEntity;


public class CityConverter {

    public static CityEntity convertCreateDtoToEntity(CityCreateDto cityCreateDto) {
        CityEntity cityEntity = new CityEntity();
        cityEntity.setName(cityCreateDto.getName());
        cityEntity.setArea(cityCreateDto.getArea());
        cityEntity.setPopulationDensity(cityCreateDto.getPopulationDensity());
        cityEntity.setPostalCode(cityCreateDto.getPostalCode());
        cityEntity.setActive(true);
        return cityEntity;
    }

    public static CityResponseDto convertEntityToResponseDto(CityEntity cityEntity) {
        CityResponseDto response = new CityResponseDto();
        response.setName(cityEntity.getName());
        response.setArea(cityEntity.getArea());
        response.setPopulationDensity(cityEntity.getPopulationDensity());
        response.setPostalCode(cityEntity.getPostalCode());
        response.setCountry(cityEntity.getCountry().getName());
        return response;
    }

    public static CityEntity convertUpdateDtoToEntity(CityUpdateDto cityUpdateDto) {
        CityEntity cityEntity = new CityEntity();
        cityEntity.setId(cityUpdateDto.getId());
        cityEntity.setName(cityUpdateDto.getName());
        cityEntity.setArea(cityUpdateDto.getArea());
        cityEntity.setPopulationDensity(cityUpdateDto.getPopulationDensity());
        cityEntity.setPostalCode(cityUpdateDto.getPostalCode());
        cityEntity.setActive(true);
        return cityEntity;
    }

}
