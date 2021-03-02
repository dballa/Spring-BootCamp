package controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import services.Request;
import services.Response;
import services.Service;

@RestController
@RequestMapping("/bmi")
public class BmiController {
	
	Service service;
	
	public BmiController(Service service) {
		this.service=service;
	}
	
	@PostMapping
	@ResponseBody
	public Response response(@RequestBody Request request) {
		return service.generateResponse(request);
	}
	
}
