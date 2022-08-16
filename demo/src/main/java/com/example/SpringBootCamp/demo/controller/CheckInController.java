package com.example.SpringBootCamp.demo.controller;

import com.example.SpringBootCamp.demo.dto.CheckInDto;
import com.example.SpringBootCamp.demo.entity.CheckInEntity;
import com.example.SpringBootCamp.demo.repository.CheckInRepository;
import com.example.SpringBootCamp.demo.service.CheckInService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@RestController
public class CheckInController {
    @Autowired
    CheckInService check;
    @Autowired
    CheckInRepository checkk;


    @ApiOperation("Adding a new checkIn")
    @PostMapping("/addcheckin")
    public CheckInEntity addCheckIn(@RequestBody CheckInDto checkIn){
        return check.saveCheckInEntity(checkIn);
    }

@ApiOperation("Getting sum")
@GetMapping("/getsum/{userid}")
public Float getSum(@PathVariable Long userId){
        return checkk.selectTotals(userId);
}

    @ApiOperation("Deleting CheckIns")
    @DeleteMapping("/deleteCheckin/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCheckIn(@PathVariable Long id){
        check.deleteAllById(id);
    }



}
