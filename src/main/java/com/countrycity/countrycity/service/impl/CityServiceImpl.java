package com.countrycity.countrycity.service.impl;

import com.countrycity.countrycity.converter.CityConverter;
import com.countrycity.countrycity.entity.CityEntity;
import com.countrycity.countrycity.entity.CountryEntity;
import com.countrycity.countrycity.exception.CityException;
import com.countrycity.countrycity.exception.CountryException;
import com.countrycity.countrycity.repository.CityRepository;
import com.countrycity.countrycity.repository.CountryRepository;
import com.countrycity.countrycity.service.CityService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@AllArgsConstructor
public class CityServiceImpl implements CityService {

    private final CityRepository cityRepository;
    private final CountryRepository countryRepository;

    @Override
    public void save(CityEntity city, Long countryId) {
        CountryEntity countryWithGivenId = countryRepository.getById(countryId);
        if(Objects.isNull(countryWithGivenId)) {
            throw new CountryException("Country does not exist!");
        }
        city.setCountry(countryWithGivenId);
        cityRepository.save(city);
    }

    @Override
    public void delete(Long id) {
        CityEntity cityWithGivenId = cityRepository.getById(id);

        if(Objects.isNull(cityWithGivenId)) {
            throw new CityException("City does not exist!");
        }
        cityRepository.delete(cityWithGivenId);
    }

    @Override
    public CityEntity update(CityEntity city, Long id) {
        CityEntity cityWithGivenId = cityRepository.getById(city.getId());
        if(Objects.isNull(cityWithGivenId)) {
            throw new CityException("City does not exist!");
        }
        CountryEntity countryEntity = countryRepository.getById(id);
        if(Objects.isNull(countryEntity)) {
            throw new CountryException("Country does not exist!");
        }
        city.setCountry(countryEntity);
        return cityRepository.update(city);
    }

    @Override
    public List<CityEntity> getAll(String name) {
        if(!Objects.isNull(name) && !name.isEmpty()){
            return cityRepository.getByName(name);
        }
        return cityRepository.getAll();
    }

    @Override
    public List<CityEntity> getByName(String name) {
        return  cityRepository.getByName(name);
    }

}
