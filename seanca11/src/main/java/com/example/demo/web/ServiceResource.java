package com.example.demo.web;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.ServiceException;
import com.example.demo.model.Service;
import com.example.demo.service.ServiceService;

@RestController
@RequestMapping("/service")
public class ServiceResource {
	private ServiceService serviceService;

	public ServiceResource(ServiceService serviceService) {
		super();
		this.serviceService = serviceService;
	}
	
	@PostMapping
	public Service add(@RequestBody Service service) {
		System.out.println(service);
		try {
			return serviceService.add(service);
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
}
