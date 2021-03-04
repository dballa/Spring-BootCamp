package com.payment.app.service;

import java.util.List;


public interface ServiceInterface {

	Response getNetSalary(Request payment);

	void addToList(Request request, Response response);

	List<String> getList();

	String getAverageSalary();
}