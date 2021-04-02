package com.countrycity.countrycity.service.impl;

import com.countrycity.countrycity.entity.CountryAPIResponse;
import com.countrycity.countrycity.entity.CountryEntity;
import com.countrycity.countrycity.exception.CountryException;
import com.countrycity.countrycity.repository.CountryRepository;
import com.countrycity.countrycity.service.CountryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Objects;

@Service
@AllArgsConstructor
public class CountryServiceImpl implements CountryService {

    private final CountryRepository countryRepository;

    @Override
    public void save(CountryEntity country) {
        CountryEntity countryWithSameName = countryRepository.getByName(country.getName());
        if(Objects.isNull(countryWithSameName)) {
            RestTemplate restTemplate = new RestTemplate();
            String URL = "https://restcountries.eu/rest/v2/name/" + country.getName() + "?fields=region;subregion;capital;numericCode;flag";
            CountryAPIResponse response = restTemplate.getForObject(URL, CountryAPIResponse[].class)[0];
            if(!Objects.isNull(response)) {
                country.setFlag(response.getFlag());
                country.setCapital(response.getCapital());
                country.setRegion(response.getRegion());
                country.setSubregion(response.getSubregion());
                country.setNumericCode(response.getNumericCode());
            }
            countryRepository.save(country);
        }else {
            throw new CountryException("Country with given name already exists");
        }
    }

    @Override
    public void delete(Long id) {
        CountryEntity countryWithNameExists = countryRepository.getById(id);
        if(Objects.isNull(countryWithNameExists)) {
            throw new CountryException("Country with given name does not exists");
        }
        countryRepository.delete(countryWithNameExists);
    }

    @Override
    public CountryEntity update(CountryEntity country) {
        CountryEntity countryToBeUpdated = countryRepository.getByName(country.getName());
        if(Objects.isNull(countryToBeUpdated)) {
            throw new CountryException("Country with given name does not exists");
        }
        country.setId(countryToBeUpdated.getId());
        return countryRepository.update(country);
    }

    @Override
    public List<CountryEntity> getAll(List<String> field, String sortType) {
        return countryRepository.getSortedCountries(field, sortType);
    }

    @Override
    public CountryEntity getByName(String name) {
        CountryEntity countryWithName = countryRepository.getByName(name);
        if(Objects.isNull(countryWithName)) {
            throw new CountryException("Country with given name does not exist!");
        }
        return countryWithName;
    }

}
