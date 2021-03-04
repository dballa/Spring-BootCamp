package com.payment.app.service;

import java.util.ArrayList;

import java.util.List;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
@Service
@Profile("prod")
public class ServiceImpl implements ServiceInterface {
	private static final double HELTH_INSURANCE = 0.017;
	private static final double SOCIAL_INSURANCE = 0.095;
	private static final double MEDIUM_INCOME_TAX = 0.13;
	private static final double HIGH_INCOME_TAX = 0.23;
	protected static List<String> list = new ArrayList<>();
	private static int counter = 0;
	private static double allNeto = 0;

	
	public Response getNeto(Request payment) {
		Response response = new Response();
		double neto;
		if (payment.getBruto() < 30000) {
			neto = (payment.getBruto());
		} else if (payment.getBruto() >= 30000 && payment.getBruto() <= 150000) {
			if (payment.getBruto() > 114670) {
				neto = (payment.getBruto() - (payment.getBruto() * HELTH_INSURANCE) - (114670 * SOCIAL_INSURANCE)
						- ((payment.getBruto() - 30000) * MEDIUM_INCOME_TAX));
			} else {
				neto = (payment.getBruto() - (payment.getBruto() * HELTH_INSURANCE)
						- (payment.getBruto() * SOCIAL_INSURANCE) - ((payment.getBruto() - 30000) * MEDIUM_INCOME_TAX));
			}
		} else {
			double incomeMediumTax = (120000 * MEDIUM_INCOME_TAX);
			double incomeHighTax = ((payment.getBruto() - 150000) * HIGH_INCOME_TAX);
			neto = (payment.getBruto() - (payment.getBruto() * HELTH_INSURANCE) - (114670 * SOCIAL_INSURANCE)
					- (incomeMediumTax + incomeHighTax));
		}
		response.setNeto(neto);
		allNeto += neto;
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
		return "The medium of all netos so far on prod profile : " + String.valueOf(medium);
	}

}
