package com.ikubinfo.ioc.detyra_jani_paga_neto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/salary")
public class SalaryResource {
@Autowired
    SalaryService service;
    @PostMapping
    private SalaryResponse response (@RequestBody SalaryRequest request) {
        return service.response(request);
    }



}
