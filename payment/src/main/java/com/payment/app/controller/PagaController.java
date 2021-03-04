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
public class PagaController {
	ServiceInterface paymentService;

	public PagaController(ServiceInterface pagaService) {
		this.paymentService = pagaService;
	}

	@PostMapping("/neto")
	public Response response(@RequestBody Request request) {
		paymentService.addToList(request,paymentService.getNeto(request));
		return paymentService.getNeto(request);
	}
	
	@GetMapping("/allcommunications")
	public List<String> showAll(){
		return paymentService.getList();
	}
	
	@GetMapping("/mediumofneto")
	public String showMedium(){
		return paymentService.getMedium();
	}
}
