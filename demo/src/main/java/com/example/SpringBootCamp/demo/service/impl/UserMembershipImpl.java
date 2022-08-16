package com.example.SpringBootCamp.demo.service.impl;

import com.example.SpringBootCamp.demo.converter.MembershipInfoConverter;
import com.example.SpringBootCamp.demo.dto.MembershipInfoDto;
import com.example.SpringBootCamp.demo.dto.UserDto;
import com.example.SpringBootCamp.demo.entity.MembershipInfoEntity;
import com.example.SpringBootCamp.demo.exceptions.UserException;
import com.example.SpringBootCamp.demo.repository.CheckInRepository;
import com.example.SpringBootCamp.demo.repository.MembershipInfoRepository;
import com.example.SpringBootCamp.demo.repository.UserRepository;
import com.example.SpringBootCamp.demo.service.UserMembershipService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
@Service
public class UserMembershipImpl implements UserMembershipService {
    @Autowired
    MembershipInfoRepository membershipInfoRepository;
    UserRepository userRepository;
    UserDto user;
    @Autowired
    CheckInRepository check;

    private static final Logger logger = LoggerFactory.getLogger(UserMembershipImpl.class);
    @Override
    public MembershipInfoEntity addUserMemb(MembershipInfoDto membership) {
        logger.info("Adding new membership");

        if (LocalDate.now().compareTo(membership.getEndDate())<0){
            check.deleteById(user.getUserId());
            logger.info("You can choose between 1 month, 2 months, 3 months or 6 months");
            if (membership.getDescription()=="1 month"){
                membership.setEndDate(LocalDate.now().plusDays(30));
                logger.info("Your membership ends on "+LocalDate.now().plusDays(30));

                membershipInfoRepository.setInValid();

            }
            if (membership.getDescription()=="2 months"){
                membership.setEndDate(LocalDate.now().plusDays(60));
                logger.info("your membership ends on "+LocalDate.now().plusDays(60));

            }
            if (membership.getDescription()=="3 months"){
                membership.setEndDate(LocalDate.now().plusDays(90));
                logger.info("Your membership ends on "+LocalDate.now().plusDays(90));

            }

            MembershipInfoEntity membtoadd= MembershipInfoConverter.toEntity(membership);
            membershipInfoRepository.addMemebrship(membtoadd);
            logger.info("Membership added");
            return membtoadd;
        }else{
            logger.info("Registration not allowed");
            throw new UserException("Your membership ends on "+membership.getEndDate());
        }
    }

    @Override
    public MembershipInfoEntity findDatesByid(Long id) {
        return (MembershipInfoEntity) membershipInfoRepository.getdatesbyId(id);
    }

    @Override
    public void deleteUserMemb(Long id) {
        if(id!=null) {
            membershipInfoRepository.deletemembership(id);
        }else{
            logger.warn("This deletion can not happen!");
            throw new UserException("Membership of user with id "+id+" does not exist!");
        }


    }
}
