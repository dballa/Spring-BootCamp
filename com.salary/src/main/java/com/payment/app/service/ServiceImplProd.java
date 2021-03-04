package com.payment.app.service;

import java.util.ArrayList;

import java.util.List;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.payment.app.util.CalculationCoefficients;
@Service
@Profile("prod")
public class ServiceImplProd implements ServiceInterface {
	
	CalculationCoefficients calculationCoefficients;
	
	protected static List<String> list = new ArrayList<>();
	private static int counter = 0;
	private static double netSalary = 0;

	
	public Response getNetSalary(Request payment) {
		Response response = new Response();
		double net;
		
		if (payment.getGrossSalary() < 30000) {
			net = (payment.getGrossSalary());
		} else if (payment.getGrossSalary() >= 30000 && payment.getGrossSalary() <= 150000) {
			if (payment.getGrossSalary() > 114670) {
				net = (payment.getGrossSalary() - (payment.getGrossSalary() * CalculationCoefficients.HEALTH_INSURANCE.getCoeff()) - (114670 * CalculationCoefficients.SOCIAL_INSURANCE.getCoeff())
						- ((payment.getGrossSalary() - 30000) * CalculationCoefficients.MEDIUM_INCOME_TAX.getCoeff()));
			} else {
				net = (payment.getGrossSalary() - (payment.getGrossSalary() * CalculationCoefficients.HEALTH_INSURANCE.getCoeff())
						- (payment.getGrossSalary() * CalculationCoefficients.SOCIAL_INSURANCE.getCoeff()) - ((payment.getGrossSalary() - 30000) * CalculationCoefficients.MEDIUM_INCOME_TAX.getCoeff()));
			}
		} else {
			double incomeMediumTax = (120000 * CalculationCoefficients.MEDIUM_INCOME_TAX.getCoeff());
			double incomeHighTax = ((payment.getGrossSalary() - 150000) * CalculationCoefficients.HIGH_INCOME_TAX.getCoeff());
			net = (payment.getGrossSalary() - (payment.getGrossSalary() * CalculationCoefficients.HEALTH_INSURANCE.getCoeff()) - (114670 * CalculationCoefficients.SOCIAL_INSURANCE.getCoeff())
					- (incomeMediumTax + incomeHighTax));
		}
		response.setNetSalary(net);
		netSalary += net;
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
		return "The average of all net Salaries in prod profile" + String.valueOf(average);
	}

}
