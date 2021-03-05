package com.grosstonet.grosstonet.web;

import com.grosstonet.grosstonet.request.GrossToNetRequest;
import com.grosstonet.grosstonet.response.GrossToNetMeanResponseDev;
import com.grosstonet.grosstonet.service.GrossToNetInterface;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class GrossToNetController {

    private final GrossToNetInterface grossToNetService;

    public GrossToNetController(GrossToNetInterface grossToNetService) {
        this.grossToNetService = grossToNetService;
    }

    @PostMapping("/grosstonet")
    public Object grossToNet(@RequestBody GrossToNetRequest grossToNetRequest) {
        return grossToNetService.convertGrossToNet(grossToNetRequest);
    }

    @GetMapping("/grosstonet/all")
    @Profile("dev")
    public List<Object> getAllRequestsAndResponses() {
        return grossToNetService.getGrossToNetRequestAndResponses();
    }

    @GetMapping("/grosstonet/mean")
    @Profile("dev")
    public Object getNetMean() {
        return grossToNetService.getNetMean();
    }

}
