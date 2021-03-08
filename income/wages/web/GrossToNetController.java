package com.income.wages.web;

import com.income.wages.request.GrossToNetRequest;
import com.income.wages.response.GrossToNetAllRequestAndResponse;
import com.income.wages.response.GrossToNetResponseProd;
import com.income.wages.service.GrossToNetInterface;


import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(method = RequestMethod.POST)
public class GrossToNetController {
	
	public final GrossToNetInterface grossToNetService;

    public GrossToNetController(GrossToNetInterface grossToNetService) {
        this.grossToNetService = grossToNetService;
    }

    @PostMapping("/net")
    public GrossToNetResponseProd response(@RequestBody GrossToNetRequest grossToNetRequest) {
    		return grossToNetService.convertToNet(grossToNetRequest);
    }
    
    
    @GetMapping("/net/all")
	public List<GrossToNetAllRequestAndResponse> getAllRequestsResponses(){
		return grossToNetService.getAllRequestsResponses();
	}


    @GetMapping("/avg")
	public double toNetAverage() {
		return grossToNetService.toNetAverage();
	}

}
