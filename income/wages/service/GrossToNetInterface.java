package com.income.wages.service;


import java.util.List;

import org.springframework.stereotype.Service;

import com.income.wages.request.GrossToNetRequest;
import com.income.wages.response.GrossToNetAllRequestAndResponse;
import com.income.wages.response.GrossToNetResponseProd;


@Service 
public interface GrossToNetInterface {
	
	public GrossToNetResponseProd convertToNet(GrossToNetRequest grossToNetRequest);
	public List<GrossToNetAllRequestAndResponse> getAllRequestsResponses();
	public double toNetAverage();

}