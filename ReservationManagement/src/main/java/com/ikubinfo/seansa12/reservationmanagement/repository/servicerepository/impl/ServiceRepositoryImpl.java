package com.ikubinfo.seansa12.reservationmanagement.repository.servicerepository.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.ikubinfo.seansa12.reservationmanagement.model.service.Services;
import com.ikubinfo.seansa12.reservationmanagement.repository.servicerepository.ServiceRepository;

@Component
public class ServiceRepositoryImpl implements ServiceRepository {

	private List <Services> services = new ArrayList<>();
	
	@Override
	public Services save(Services service) {
		
		if(services.add(service)) {
			return service;
		}else {
			return null;
		}
	}

	@Override
	public Services update(Services service) {
		
		for (Services existingService : services){
			if (existingService.getCode().equals(service.getCode())) {
				services.set(services.indexOf(existingService), service);
				return service;
			}
		}
		return null;
	}

	@Override
	public boolean delete(String code) {
		
		for (Services service : services) {
			if (service.getCode().equals(code)) {
				return services.remove(service);
			}
		}
		return false;
	}

	@Override
	public List<Services> getAll() {
		
		return services;
	}

	@Override
	public Services findService(String code) {
		
		for (Services service : services) {
			if (service.getCode().equals(code)) {
				return service;
			}
		}
		return null;
	}

	@Override
	public boolean existServiceWithCode(String code) {
		
		for (Services service : services) {
			if (service.getCode().equals(code)) {
				return true;
			}
		}
		return false;
	}

}
