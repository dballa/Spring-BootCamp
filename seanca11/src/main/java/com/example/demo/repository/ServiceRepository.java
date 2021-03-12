package com.example.demo.repository;

import com.example.demo.model.Service;

public interface ServiceRepository {
	
	Service add(Service service);
	
	Service getServiceByName(String name);
}
