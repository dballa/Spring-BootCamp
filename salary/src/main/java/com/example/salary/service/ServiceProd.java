package com.example.salary.service;
import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("Prod")
public class ServiceProd implements SalaryInterface {

		private  double  allNet = 0;
		public List<InfoShow> infoShowR;
		public List<RequestSalary> requestSalaries;
		

		public ServiceProd() {
			super();
			infoShowR =new ArrayList<>() ;
			requestSalaries=new ArrayList<>();
		}

		@Override
		public ResponseSalary getResponseNeto(RequestSalary requestSalary) {
			requestSalaries.add(requestSalary);
			ResponseSalary responseSalary=new ResponseSalary();
			if( requestSalary.getGross() > 0 && requestSalary.getGross() <= 30000 ){
				responseSalary.setNet(requestSalary.getGross());
			}
			else if( requestSalary.getGross() > 30000 && requestSalary.getGross() <= 150000 ) {
				responseSalary.setNet(requestSalary.getGross()*(1-0.13));
			}
			else if( requestSalary.getGross() > 150000) {
				responseSalary.setNet(requestSalary.getGross()*(1-0.23));
			}
			allNet=allNet+responseSalary.getNet();
			InfoShow infoShow=new InfoShow(requestSalary.getGross(),responseSalary.getNet());
			infoShowR.add(infoShow);
			return responseSalary;
		}
		
		
		@Override
		public double getAllNetoAvarage() {
			
		return allNet/requestSalaries.size();	
			
		}

		

		@Override
		public List<InfoShow> getInfo() {
			return infoShowR;
		}
		
		
		
}
