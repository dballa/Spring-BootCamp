package com.countrycity.countrycity.service;

import com.countrycity.countrycity.entity.CityEntity;

import java.util.List;

public interface CityService {

    void save(CityEntity city, Long countryId);
    void delete(Long id);
    CityEntity update(CityEntity city, Long id);
    List<CityEntity> getAll(String name);
    List<CityEntity> getByName(String name);

}
