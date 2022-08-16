package com.example.SpringBootCamp.demo.service;

import com.example.SpringBootCamp.demo.dto.MotivationDto;
import com.example.SpringBootCamp.demo.entity.MotivationEntity;

import java.util.List;

public interface QuoteService {
    List<MotivationEntity> getallMotivationQuote();
    MotivationEntity addmotivationquote(MotivationDto motivation);


}
