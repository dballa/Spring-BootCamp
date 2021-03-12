package com.example.demo.service;

import com.example.demo.ServiceException;
import com.example.demo.model.Service;

public interface ServiceService {
	
	Service add(Service service) throws ServiceException;
}
