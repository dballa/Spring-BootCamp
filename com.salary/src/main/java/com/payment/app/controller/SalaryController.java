package com.payment.app.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.payment.app.service.Request;
import com.payment.app.service.Response;
import com.payment.app.service.ServiceInterface;

@RestController
@RequestMapping
public class SalaryController {
	ServiceInterface paymentService;

	public SalaryController(ServiceInterface salaryService) {
		this.paymentService = salaryService;
	}

	@PostMapping("/net")
	public Response response(@RequestBody Request request) {
		paymentService.addToList(request,paymentService.getNetSalary(request));
		return paymentService.getNetSalary(request);
	}
	
	@GetMapping("/communications")
	public List<String> showAll(){
		return paymentService.getList();
	}
	
	@GetMapping("/netsAverage")
	public String showAverageSalary(){
		return paymentService.getAverageSalary();
	}
}
