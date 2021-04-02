package com.countrycity.countrycity.controller;

import com.countrycity.countrycity.converter.CityConverter;
import com.countrycity.countrycity.converter.CountryConverter;
import com.countrycity.countrycity.dto.city.CityCreateDto;
import com.countrycity.countrycity.dto.city.CityResponseDto;
import com.countrycity.countrycity.dto.city.CityUpdateDto;
import com.countrycity.countrycity.dto.country.CountryCreateDto;
import com.countrycity.countrycity.dto.country.CountryResponseDto;
import com.countrycity.countrycity.dto.country.CountryUpdateDto;
import com.countrycity.countrycity.service.CityService;
import com.countrycity.countrycity.service.CountryService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/countries")
public class MainController {

    private final CountryService countryService;
    private final CityService cityService;

    @PostMapping
    public void createCountry(@RequestBody CountryCreateDto country) {
        countryService.save(CountryConverter.convertCreateDtoToEntity(country));
    }

    @GetMapping
    public ResponseEntity<List<CountryResponseDto>> getAllCountries(
            @RequestParam(required = false, defaultValue = "name") List<String> sort_by,
            @RequestParam(required = false, defaultValue = "desc") String order
    ) {
        List<CountryResponseDto> response = new ArrayList<>();
        countryService.getAll(sort_by, order).forEach(country -> response.add(CountryConverter.convertEntityToResponseDto(country)));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{name}")
    public ResponseEntity<CountryResponseDto> getCountryByName(@PathVariable String name){
        return new ResponseEntity<>(CountryConverter.convertEntityToResponseDto(countryService.getByName(name)), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public void deleteCountry(@PathVariable Long id) {
        countryService.delete(id);
    }

    @PutMapping
    public ResponseEntity<CountryResponseDto> updateCountry(@RequestBody CountryUpdateDto update){
        return new ResponseEntity<>(CountryConverter.convertEntityToResponseDto(countryService.update(CountryConverter.convertUpdateDtoToEntity(update))), HttpStatus.OK);
    }

    @PostMapping("/cities")
    public void createCity(@RequestBody CityCreateDto city) {
        cityService.save(CityConverter.convertCreateDtoToEntity(city), city.getCountryId());
    }

    @GetMapping("/cities")
    public ResponseEntity<List<CityResponseDto>> getAllCities(@RequestParam(required = false) String name) {
        List<CityResponseDto> response = new ArrayList<>();
        cityService.getAll(name).forEach(city -> response.add(CityConverter.convertEntityToResponseDto(city)));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping("/cities")
    public ResponseEntity<CityResponseDto> updateCity(@RequestBody CityUpdateDto cityUpdateDto) {
        return new ResponseEntity<>(CityConverter.convertEntityToResponseDto(cityService.update(CityConverter.convertUpdateDtoToEntity(cityUpdateDto), cityUpdateDto.getCountryId())), HttpStatus.OK);
    }

    @DeleteMapping("/cities/{id}")
    public void deleteCity(@PathVariable Long id) {
        cityService.delete(id);
    }



}
