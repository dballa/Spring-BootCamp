package com.example.demo.service.impl;


import org.springframework.stereotype.Service;

import com.example.demo.ServiceException;
import com.example.demo.repository.ServiceRepository;
import com.example.demo.service.ServiceService;

@Service
public class ServiceServiceImpl implements ServiceService {
	
	private ServiceRepository serviceRepository;
	
	public ServiceServiceImpl(ServiceRepository serviceRepository) {
		super();
		this.serviceRepository = serviceRepository;
	}

	@Override
	public com.example.demo.model.Service add(com.example.demo.model.Service service) throws ServiceException {
		if(serviceRepository.getServiceByName(service.getName()) == null) {
			serviceRepository.add(service);
			return service;
		}else {
			throw new ServiceException("Service with name : " + service.getName() + " already exist!");
		}
	}

}
