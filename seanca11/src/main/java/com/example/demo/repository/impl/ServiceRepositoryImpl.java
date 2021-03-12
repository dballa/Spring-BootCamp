package com.example.demo.repository.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.example.demo.model.Service;
import com.example.demo.repository.ServiceRepository;
@Component
public class ServiceRepositoryImpl implements ServiceRepository {
	
	private static List<Service> services = new ArrayList<Service>();
	
	@Override
	public Service add(Service service) {
		services.add(service);
		return service;
	}
	@Override
	public Service getServiceByName(String name) {
		Service service = null;
		for (Service s : services) {
			if(s.getName().equals(name)) {
				service=s;
			}
		}
		return service;
	}

}
