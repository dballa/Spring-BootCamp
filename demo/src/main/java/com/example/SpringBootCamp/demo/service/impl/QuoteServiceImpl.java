package com.example.SpringBootCamp.demo.service.impl;


import com.example.SpringBootCamp.demo.converter.MotivationConverter;
import com.example.SpringBootCamp.demo.dto.MotivationDto;
import com.example.SpringBootCamp.demo.entity.MotivationEntity;
import com.example.SpringBootCamp.demo.repository.MotivationRepository;
import com.example.SpringBootCamp.demo.service.QuoteService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class QuoteServiceImpl implements QuoteService {
    public static final Logger logger= LoggerFactory.getLogger(QuoteServiceImpl.class);
    @Autowired
    MotivationRepository motivationRepository;



    public MotivationEntity addmotivationquote(MotivationDto motivation) {

        MotivationEntity motivationn= MotivationConverter.toEntity(motivation);
        motivationRepository.addMotivation(motivationn);
        return null;
    }
    @Override
    public List<MotivationEntity> getallMotivationQuote() {
        return motivationRepository.getallMotivation();
    }
}
