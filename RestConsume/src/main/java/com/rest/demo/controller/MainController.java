package com.rest.demo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rest.demo.converter.LocationConverter;
import com.rest.demo.converter.UserConverter;
import com.rest.demo.dto.LocationDto;
import com.rest.demo.dto.UserDto;
import com.rest.demo.dto.UserDtoCreate;
import com.rest.demo.dto.WeatherDto;
import com.rest.demo.service.LocationService;
import com.rest.demo.service.UserService;
import com.rest.demo.service.WeatherService;

@RestController
@RequestMapping("/api/v1")
public class MainController {

	UserService userService;
	LocationService locService;
	WeatherService weatherService;

	@Autowired
	public MainController(UserService userService, LocationService locService, WeatherService weatherService) {
		super();
		this.userService = userService;
		this.locService = locService;
		this.weatherService = weatherService;
	}

	// GET USER BY ID
	@GetMapping("/users/{id}")
	public ResponseEntity<UserDto> showUserById(@PathVariable int id) {
		return new ResponseEntity<>(UserConverter.toDto(userService.getUserById(id)), HttpStatus.OK);
	}

	// GET ALL USERS OR FILTERED BY CITY NAME
	@GetMapping("/users")
	public ResponseEntity<List<UserDto>> showUsers(@RequestParam(required = false) String city,
			@RequestParam(required = false) Boolean sortByName) {
		List<UserDto> toReturn = new ArrayList<>();
		userService.showUsersByAndOrdered(city, sortByName)
				.forEach(entity -> toReturn.add(UserConverter.toDto(entity)));
		return new ResponseEntity<>(toReturn, HttpStatus.OK);
	}

	// GET WEATHER DATA FOR USER WITH ID GIVEN
	@GetMapping("/users/{id}/weather")
	public ResponseEntity<WeatherDto> getUserWeather(@PathVariable int id) {
		return new ResponseEntity<>(userService.getUserWeather(id), HttpStatus.CREATED);
	}

	// CREATE NEW USER
	@PostMapping("/users")
	public ResponseEntity<UserDto> insertUsers(@Valid @RequestBody UserDtoCreate user) {
		return new ResponseEntity<>(UserConverter.toDto(userService.insertUsers(user)), HttpStatus.CREATED);
	}

	// UPDATE THE USER BY ID
	@PutMapping("/users/{id}")
	public ResponseEntity<UserDto> updateUsers(@Valid @RequestBody UserDtoCreate user, @PathVariable int id) {
		return new ResponseEntity<>(UserConverter.toDto(userService.updateUsers(user, id)), HttpStatus.CREATED);
	}

	// DELETE USER BY ID
	@DeleteMapping("/users/{id}")
	public ResponseEntity<UserDto> deleteUsers(@PathVariable int id) {
		return new ResponseEntity<>(UserConverter.toDto(userService.deleteUsers(id)), HttpStatus.NO_CONTENT);
	}

	/*---------------------------------------------------*/
	/*---------------------------------------------------*/
	/*---------------------------------------------------*/

	// GET ALL LOCATIONS
	@GetMapping("/locations")
	public ResponseEntity<List<LocationDto>> showLocations() {
		return new ResponseEntity<>(LocationConverter.toDto(locService.getLocations()), HttpStatus.OK);
	}

	// GET ALL LOCATIONS
	@GetMapping("/locations/{id}")
	public ResponseEntity<LocationDto> showLocationById(@PathVariable int id) {
		return new ResponseEntity<>(LocationConverter.toDto(locService.getLocationById(id)), HttpStatus.OK);
	}
	
	// GET LOCATION WEATHER DATA
	@GetMapping("/locations/{id}/weather")
	public ResponseEntity<WeatherDto> showWeatherByLocations(@PathVariable int id) {
		String city = locService.getLocationById(id).getCity();
		return new ResponseEntity<>(weatherService.getWeatherByCity(city), HttpStatus.OK);
	}

	// CREATE NEW LOCATION
	@PostMapping("/locations")
	public ResponseEntity<LocationDto> insertLocations(@Valid @RequestBody LocationDto location) {
		return new ResponseEntity<>(LocationConverter.toDto(locService.insertLocation(location)), HttpStatus.CREATED);
	}

	// UPDATE LOCATION
	@PutMapping("/locations/{id}")
	public ResponseEntity<LocationDto> updateLocations(@Valid @RequestBody LocationDto location, @PathVariable int id) {
		return new ResponseEntity<>(LocationConverter.toDto(locService.updateLocation(location, id)),
				HttpStatus.CREATED);
	}

	// DELETE LOCATION IF EXIST AND NOT IN USE
	@DeleteMapping("/locations/{id}")
	public void deleteLocations(@PathVariable int id) {
		locService.deleteLocation(id);
	}
}
