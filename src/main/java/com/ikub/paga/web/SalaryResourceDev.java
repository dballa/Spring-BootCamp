package com.ikub.paga.web;

import com.ikub.paga.request.SalaryRequest;
import com.ikub.paga.response.SalaryResponseDev;
import com.ikub.paga.service.SalaryServiceDev;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
@Profile("dev")
@RestController
@RequestMapping("/bruto")
public class SalaryResourceDev {

    private SalaryServiceDev service;

    @Value("${spring.mode}")
    private String appType;

    public SalaryResourceDev(SalaryServiceDev service){
        this.service = service;
    }

    @PostMapping
    public SalaryResponseDev getNeto(@RequestBody SalaryRequest request){
        System.out.println(request+ appType);
        return service.getNeto(request );
    }

    @PostMapping("/reqs")
    public HashMap<SalaryRequest, SalaryResponseDev> getAll(){
        System.out.println("Printing everything" + appType);
        return service.getRequests();
    }
    @PostMapping("/avg")
    public Double averageNetos(){
        System.out.println("Calculating netos avg" + appType);
        return service.averageNeto();
    }
}
