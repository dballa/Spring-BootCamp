package com.ikub.paga.web;

import com.ikub.paga.request.SalaryRequest;
import com.ikub.paga.response.SalaryResponse;
import com.ikub.paga.service.SalaryService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping("/bruto")
public class SalaryResource {

    private SalaryService service;

    @Value("${spring.mode}")
    private String appType;

    public SalaryResource(SalaryService service){
        this.service = service;
    }

    @PostMapping
    public SalaryResponse getNeto(@RequestBody SalaryRequest request){
        System.out.println(request+ appType);
        return service.getNeto(request );
    }

    @PostMapping("/reqs")
    public HashMap<SalaryRequest, SalaryResponse> getAll(){
        System.out.println("Printing everything" + appType);
        return service.getRequests();
    }
    @PostMapping("/avg")
    public Double averageNetos(){
        System.out.println("Calculating netos avg" + appType);
        return service.averageNeto();
    }
}
