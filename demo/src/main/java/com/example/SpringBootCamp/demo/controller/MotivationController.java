package com.example.SpringBootCamp.demo.controller;

import com.example.SpringBootCamp.demo.converter.MotivationConverter;
import com.example.SpringBootCamp.demo.dto.MotivationDto;
import com.example.SpringBootCamp.demo.service.QuoteService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController

public class MotivationController {


@Autowired
QuoteService quoteService;



    @ApiOperation(value="Getting a daily QUOTE ")
    @GetMapping("/motivation")
    public ResponseEntity<List<MotivationDto>>getmotivation(){
        List<MotivationDto> toReturn = new ArrayList<>();
        quoteService.getallMotivationQuote().forEach(entity -> toReturn.add(MotivationConverter.toDto(entity)));
        return new ResponseEntity<List<MotivationDto>>(toReturn, HttpStatus.OK);
    }

    @ApiOperation(value="Adding a new user")
    @PostMapping("/motivation")
    public ResponseEntity<MotivationDto> addMotivation(@Valid @RequestBody MotivationDto motivationDto){
        return new ResponseEntity<>(MotivationConverter.toDto(quoteService.addmotivationquote(motivationDto)),HttpStatus.CREATED);
    }
}
