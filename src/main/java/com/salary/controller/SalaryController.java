package com.salary.controller;



import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.salary.model.AverageResponse;
import com.salary.model.HistoryItem;
import com.salary.model.SalaryRequest;
import com.salary.model.SalaryResponse;
import com.salary.service.SalaryService;

@RestController
@RequestMapping
public class SalaryController {

	private static List<HistoryItem> history = new ArrayList<>();
	// call them by interface name
	SalaryService salaryService;
	 
	public SalaryController(SalaryService salaryService) {
		this.salaryService = salaryService;
	}
	
	@PostMapping("/neto")
	public SalaryResponse netSalary(@RequestBody SalaryRequest request) {
		System.out.println(request);
		SalaryResponse response = salaryService.calculateNet(request);
	
		HistoryItem item = new HistoryItem(); 
		item.setGrossSalary(request.getGrossSalary());
		item.setNetSalary(response.getNetSalary());
		history.add(item);
		
		return response;
	}
	
	@GetMapping("/neto/history")
	public List<HistoryItem> history(){
		return history;
	}
	
	@GetMapping("/neto/history/average")
	public AverageResponse average() {
		AverageResponse averageResponse = new AverageResponse();
		double sum=0;
		
		for(HistoryItem item: history) 
			sum =sum + item.getNetSalary();
		
		averageResponse.setAverage(sum/history.size());
		averageResponse.setCount(history.size());
		
		return averageResponse;
	}
}
