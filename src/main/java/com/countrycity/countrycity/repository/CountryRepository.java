package com.countrycity.countrycity.repository;

import com.countrycity.countrycity.entity.CountryEntity;

import java.util.List;

public interface CountryRepository {

    void save(CountryEntity country);
    void delete(CountryEntity country);
    CountryEntity update(CountryEntity country);
    CountryEntity getByName(String name);
    CountryEntity getById(Long id);
    List<CountryEntity> getSortedCountries(List<String> field, String type);


}
