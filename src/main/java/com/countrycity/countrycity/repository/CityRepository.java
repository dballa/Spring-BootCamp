package com.countrycity.countrycity.repository;

import com.countrycity.countrycity.entity.CityEntity;

import java.util.List;

public interface CityRepository {

    void save(CityEntity city);
    void delete(CityEntity city);
    CityEntity update(CityEntity city);
    List<CityEntity> getAll();
    CityEntity getById(Long id);
    List<CityEntity> getByName(String name);
}
