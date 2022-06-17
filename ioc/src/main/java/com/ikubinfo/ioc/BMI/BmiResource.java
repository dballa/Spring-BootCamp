package com.ikubinfo.ioc.BMI;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/bmi")
public class BmiResource {
    BMIService service;

        @PostMapping
        private BmiResponse response (@RequestBody BmiRequest request) {
            return service.response(request);
        }

    }

