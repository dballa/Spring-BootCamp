package com.income.wages.service;


import com.income.wages.request.GrossToNetRequest;
import com.income.wages.response.GrossToNetAllRequestAndResponse;
import com.income.wages.response.GrossToNetResponseProd;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Profile;

import org.springframework.stereotype.Service;



@Service
@Profile("dev")
public class GrossToNetServiceDev implements GrossToNetInterface {
	private double sum=0;
	public List<GrossToNetRequest> grossToNetRequests;
	public List<GrossToNetAllRequestAndResponse> grossToNetAllRequestsResponses;

    
	public GrossToNetServiceDev(){
		this.grossToNetRequests= new ArrayList<>();
		this.grossToNetAllRequestsResponses=new ArrayList<>();
	}
    
    public GrossToNetResponseProd convertToNet(GrossToNetRequest grossToNetRequest) {
    	grossToNetRequests.add(grossToNetRequest);
    	sum=sum+grossToNetRequest.getGrossIncome();
    	GrossToNetResponseProd response = new GrossToNetResponseProd();
		response.setNetIncome(( grossToNetRequest).getGrossIncome() * 0.91);
		GrossToNetAllRequestAndResponse responseAll= new GrossToNetAllRequestAndResponse(grossToNetRequest.getGrossIncome(),response.getNetIncome());
		grossToNetAllRequestsResponses.add(responseAll);
		return response;
	}

	
	@Override
	public List<GrossToNetAllRequestAndResponse> getAllRequestsResponses() {
		return grossToNetAllRequestsResponses;
	}
	
	@Override
	public double toNetAverage() {
		return sum/grossToNetAllRequestsResponses.size();
	}

	

	

	

	

	
}