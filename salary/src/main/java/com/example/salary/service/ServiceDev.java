// [paga neto = paga bruto X 0.91]

package com.example.salary.service;
import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("dev")
public class ServiceDev implements SalaryInterface {

		private  double  allNet = 0;
		public List<InfoShow> infoShowR;
		public List<RequestSalary> requestSalaries;
		

		public ServiceDev() {
			super();
			infoShowR =new ArrayList<>() ;
			requestSalaries=new ArrayList<>();
		}

		@Override
		public ResponseSalary getResponseNeto(RequestSalary requestSalary) {
			requestSalaries.add(requestSalary);
			ResponseSalary responseSalary=new ResponseSalary();
			double value=(requestSalary.getGross()*0.91);
			responseSalary.setNet(value);
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
