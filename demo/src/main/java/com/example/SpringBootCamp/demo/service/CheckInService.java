package com.example.SpringBootCamp.demo.service;


import com.example.SpringBootCamp.demo.converter.CheckInConverter;
import com.example.SpringBootCamp.demo.dto.CheckInDto;
import com.example.SpringBootCamp.demo.dto.MembershipInfoDto;
import com.example.SpringBootCamp.demo.entity.CheckInEntity;
import com.example.SpringBootCamp.demo.exceptions.MembershipException;
import com.example.SpringBootCamp.demo.repository.CheckInRepository;
import com.example.SpringBootCamp.demo.repository.MembershipInfoRepository;
import com.example.SpringBootCamp.demo.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.time.LocalDate;


@Service
public class CheckInService {
    private static final Logger logger = LoggerFactory.getLogger(CheckInService.class);
    public static final String GET_SUM = "Select sum(userId) from CheckInEntity checkin where id=?1";
    @Autowired
    CheckInRepository checkInRepository;
    @Autowired
    MembershipInfoRepository membershipInfoRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    EntityManager entityManager;

    public void deleteAllById(long id) {
        checkInRepository.deleteById(id);
    }


    public CheckInEntity saveCheckInEntity(CheckInDto checkIn) {
        CheckInEntity check = CheckInConverter.toEntity(checkIn);




            checkInRepository.findById((long) check.getUserId());
            check.setTimes(1);
            return checkInRepository.save(check);

        }


    }

