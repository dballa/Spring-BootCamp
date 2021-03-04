package com.ikub.paga.web;

import com.ikub.paga.request.SalaryRequest;
import com.ikub.paga.response.SalaryResponseProd;
import com.ikub.paga.service.SalaryServiceProd;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
@Profile("prod")
@RestController
@RequestMapping("/bruto")
public class SalaryResourceProd {

    private SalaryServiceProd service;
    @Value("${spring.mode}")
    private String appType;
    public SalaryResourceProd(SalaryServiceProd service){
        this.service = service;
    }

    @PostMapping
    public SalaryResponseProd getNeto(@RequestBody SalaryRequest request){
        System.out.println(request + appType);
        return service.getNeto(request);
    }

    @PostMapping("/reqs")
    public HashMap<SalaryRequest, SalaryResponseProd> getAll(){
        System.out.println("Printing everything" + appType);
        return service.getRequests();
    }
    @PostMapping("/avg")
    public Double averageNetos(){
        System.out.println("Calculating netos avg" + appType);
        return service.averageNeto();
    }
}
