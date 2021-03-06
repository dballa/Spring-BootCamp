package com.example.salary.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.salary.service.InfoShow;
import com.example.salary.service.RequestSalary;
import com.example.salary.service.ResponseSalary;
import com.example.salary.service.SalaryInterface;

@RestController
@RequestMapping()
public class Resource {

	@Autowired
	private SalaryInterface salaryInterface;
	
	
	@PostMapping("/request")
	public ResponseSalary getResponse(@RequestBody RequestSalary requestSalary) {
		return salaryInterface.getResponseNeto(requestSalary);
	}
	
	@GetMapping("/allrequest")
	public List<InfoShow> show(){
		return salaryInterface.getInfo();
	}
	@GetMapping("/avarageneto")
	public double getAvarage() {
		return salaryInterface.getAllNetoAvarage();
	}
}
