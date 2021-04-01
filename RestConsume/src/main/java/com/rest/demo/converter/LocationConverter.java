package com.rest.demo.converter;

import com.rest.demo.dto.LocationDto;
import com.rest.demo.entity.LocationEntity;

import java.util.ArrayList;
import java.util.List;



public class LocationConverter {
	
	private LocationConverter () {}
	
	public static LocationDto toDto(LocationEntity entity) {
		LocationDto toReturn = new LocationDto();
		toReturn.setCity(entity.getCity());
		return toReturn;
	}
	
	public static List<LocationDto> toDto(List<LocationEntity> entity) {
		List<LocationDto> toReturn = new ArrayList<>();
		for(LocationEntity ue : entity) {
			toReturn.add(toDto(ue));
		}
		return toReturn;
	}

	public static LocationEntity toEntityForCreate(LocationDto dto) {
		LocationEntity toReturn=new LocationEntity();
		toReturn.setLocationId(null);
		toReturn.setCity(dto.getCity());
		return toReturn;
	}
}
