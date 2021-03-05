package com.springboot.controller;

import org.springframework.http.HttpRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sun.org.apache.xalan.internal.xsltc.compiler.sym;

@RestController
@RequestMapping("/api")
public class TestController {

	
	
	
	
	
	@GetMapping(path="/dev/{salary}")
	public String getSalaryDev( @PathVariable Double salary) {
		
		Double netoSalary= salary * 0.91;
		
		
		return  "Paga neto e llogaritur duke marre si input pagen bruto = " + netoSalary ;
	}
	
	@GetMapping(path="/prod/{salary}")
	public String getSalaryProd(@PathVariable Double salary) {
		Double netoSalary;

		Double kontShend=0.017, sigShoq=0.095, tap1=0.13, tap2=0.23 ;
			
			if(salary<=30000){
			
		System.out.println("Kontributet shendetesore "+  salary * kontShend);
		System.out.println("Kontributet shoqerore "+  salary * sigShoq);	
		netoSalary=  salary - (salary * sigShoq +  salary * kontShend);
		

			 
		}else if(salary>30000 && salary<=150000) {
			
			System.out.println("Kontributet shendetesore "+  salary * kontShend);
			System.out.println("Kontributet shoqerore "+  salary * sigShoq);
			System.out.println("TAP1 "+  salary * tap1);
			netoSalary=  salary - (salary * sigShoq +  salary * kontShend + salary * tap1);
			
		
		}else{
			System.out.println("Kontributet shendetesore "+  salary * kontShend);
			System.out.println("Kontributet shoqerore "+  salary * sigShoq);
			System.out.println("TAP2 "+  salary * tap2);
			netoSalary=  salary - (salary * sigShoq +  salary * kontShend + salary * tap2);
			
		}
				
		
		
		
		return "Paga neto " + netoSalary;
	}
	
	
	

}
