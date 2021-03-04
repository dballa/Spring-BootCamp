package com.payment.app.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
@Service
@Profile("dev")
public class ServiceImplSecond implements ServiceInterface{
	private static int counter = 0;
	private static double allNeto = 0;
	protected static List<String> list = new ArrayList<>();
	
	@Override
	public Response getNeto(Request payment) {
		Response response = new Response();
		response.setNeto((payment.getBruto()*0.91));
		allNeto += payment.getBruto();
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

	public String getMedium() {
		double medium = allNeto / counter;
		return "The medium of all netos so far is on dev profile : " + String.valueOf(medium);
	}


}
