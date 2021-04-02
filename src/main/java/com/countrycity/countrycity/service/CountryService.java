package com.countrycity.countrycity.service;

import com.countrycity.countrycity.entity.CountryEntity;

import java.util.List;

public interface CountryService {

    void save(CountryEntity country);
    void delete(Long id);
    CountryEntity update(CountryEntity country);
    List<CountryEntity> getAll(List<String> sort_by, String order);
    CountryEntity getByName(String name);


}
