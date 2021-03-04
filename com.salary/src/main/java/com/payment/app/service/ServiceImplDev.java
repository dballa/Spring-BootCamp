package com.payment.app.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
@Service
@Profile("dev")
public class ServiceImplDev implements ServiceInterface{
	
	private static int counter = 0;
	private static double netSalary = 0;
	
	protected static List<String> list = new ArrayList<>();
	
	@Override
	public Response getNetSalary(Request payment) {
		Response response = new Response();
		response.setNetSalary((payment.getGrossSalary()*0.91));
		netSalary += payment.getGrossSalary();
		counter++;
		return response;
	}
	public void addToList(Request request, Response response) {
		list.add(request.toString());
		list.add(response.toString());
	}

	public List<String> getList() {
		return list;
	}

	public String getAverageSalary() {
		double average = netSalary / counter;
		return "The average of all net Salaries in dev profile : " + String.valueOf(average);
	}


}
