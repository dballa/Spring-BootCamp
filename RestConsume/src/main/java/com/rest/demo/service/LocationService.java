package com.rest.demo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.demo.converter.LocationConverter;
import com.rest.demo.dto.LocationDto;
import com.rest.demo.entity.LocationEntity;
import com.rest.demo.exceptions.MyException;
import com.rest.demo.repository.LocationRepository;
import com.rest.demo.repository.UserRepository;

@Service
@Transactional
public class LocationService {
	
	LocationRepository locRepo;
	WeatherService weatherService;
	UserRepository userRepo;
	
	@Autowired
	public LocationService(LocationRepository locRepo,WeatherService weatherService,UserRepository userRepo) {
		super();
		this.locRepo = locRepo;
		this.userRepo = userRepo;
		this.weatherService = weatherService;
	}

	public List<LocationEntity> getLocations() {
		return locRepo.getLocations();
	}

	public LocationEntity insertLocation(LocationDto location) {
		if(location != null) {
			if(locRepo.getLocationByCity(location.getCity())==null) {
				LocationEntity locationToAdd = LocationConverter.toEntityForCreate(location);
				locRepo.insertLocation(locationToAdd);
				return locationToAdd;
			}else {
				throw new MyException("Location already exist !");
			}
		}else{
			throw new MyException("Location body is empty !");
		}
	}

	public LocationEntity getLocationById(int id) {
		LocationEntity location = locRepo.getLocationById(id);
		if(location!=null) {
			return location;
		}
		throw new MyException("No Location with given id !");
	}

	public LocationEntity updateLocation(LocationDto location, int id) {
		LocationEntity locationCheck = locRepo.getLocationById(id);
		if(locationCheck != null) {
			if(location.getCity()!=locationCheck.getCity() && locRepo.getLocationByCity(location.getCity())!=null) {
				throw new MyException("City Name already exist !");
			}else {
				locationCheck.setCity(location.getCity());
				locRepo.updateLocation(locationCheck);
				return locationCheck;
			}
		}else {
			throw new MyException("No Location with given id !");
		}
	}
		
	public void deleteLocation(int id) {
		LocationEntity locationToDelete = locRepo.getLocationById(id);
		if(locationToDelete!=null) {
			if(userRepo.getUserByLocation(locationToDelete)) {
				throw new MyException("Location belongs to a user !");
			}else {
				locRepo.deleteLocation(locationToDelete);
			}
		}else {
			throw new MyException("Location with given Id does not exist !");
		}
	}
}
