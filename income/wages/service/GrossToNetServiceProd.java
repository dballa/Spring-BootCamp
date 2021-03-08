package com.income.wages.service;


import com.income.wages.request.GrossToNetRequest;
import com.income.wages.response.*;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Profile("prod")
public class GrossToNetServiceProd implements GrossToNetInterface{
	private double sum=0;
	public List<GrossToNetRequest> grossToNetRequests;
	public List<GrossToNetAllRequestAndResponse> grossToNetAllRequestsResponses;

	
    public GrossToNetServiceProd() {
    	this.grossToNetRequests= new ArrayList<>();
		this.grossToNetAllRequestsResponses=new ArrayList<>();
    }

    public GrossToNetResponseProd convertToNet(GrossToNetRequest grossToNetRequest) {
    	grossToNetRequests.add(grossToNetRequest);
    	sum=sum+grossToNetRequest.getGrossIncome();
    	GrossToNetResponseProd grossToNetResponse = new GrossToNetResponseProd();
        double grossIncome = grossToNetRequest.getGrossIncome();
 
        double socialInsurance = generateSocialInsurance(grossToNetRequest);
        double healthInsurance = generateHealthInsurance(grossToNetRequest);
        double tax = generateTax(grossToNetRequest);
        double netIncome = grossIncome - healthInsurance - socialInsurance - tax;
        grossToNetResponse.setNetIncome(netIncome);
        GrossToNetAllRequestAndResponse responseAll= new GrossToNetAllRequestAndResponse(grossToNetRequest.getGrossIncome(),grossToNetResponse.getNetIncome());
        grossToNetAllRequestsResponses.add(responseAll);
        return grossToNetResponse;
    }


    private double generateTax(GrossToNetRequest grossToNetRequest) {
        double grossIncome = grossToNetRequest.getGrossIncome();
        if(grossIncome < 30000) {
            return 0;
        } else if (grossIncome < 150000){
            return (grossIncome - 30000) * 0.13;
        } else {
            return 15600 + (grossIncome - 150000) * 0.23;
        }
    }

    private double generateSocialInsurance(GrossToNetRequest grossToNetRequest) {
        return grossToNetRequest.getGrossIncome() * 0.095;
    }

    private double generateHealthInsurance(GrossToNetRequest grossToNetRequest) {
        return 0.017 * grossToNetRequest.getGrossIncome();
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
