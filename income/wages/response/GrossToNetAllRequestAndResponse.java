package com.income.wages.response;

public class GrossToNetAllRequestAndResponse {

    private double grossToNetRequests;
    private double grossToNetResponses;

    public GrossToNetAllRequestAndResponse(double grossToNetRequests, double grossToNetResponses) {
    	this.grossToNetRequests=grossToNetRequests;
    	this.grossToNetResponses=grossToNetResponses;
		}



	public double getGrossToNetRequests() {
		return grossToNetRequests;
	}



	public void setGrossToNetRequests(double grossToNetRequests) {
		this.grossToNetRequests = grossToNetRequests;
	}



	public double getGrossToNetResponses() {
		return grossToNetResponses;
	}



	public void setGrossToNetResponses(double grossToNetResponses) {
		this.grossToNetResponses = grossToNetResponses;
	}



	@Override
    public String toString() {
        return "GrossToNetAllRequestAndResponseDev{" +
                "grossToNetRequest=" + grossToNetRequests +
                "grossToNetResponse=" + grossToNetResponses +
                '}';
    }



	public double getGrossIncome() {
		// TODO Auto-generated method stub
		return 0;
	}

	
}
