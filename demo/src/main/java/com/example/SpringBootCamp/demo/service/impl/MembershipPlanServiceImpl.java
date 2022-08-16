package com.example.SpringBootCamp.demo.service.impl;



import com.example.SpringBootCamp.demo.converter.MembershipConverter;
import com.example.SpringBootCamp.demo.dto.MembershipDto;
import com.example.SpringBootCamp.demo.entity.MembershipEntity;
import com.example.SpringBootCamp.demo.repository.MembershippRepository;
import com.example.SpringBootCamp.demo.service.MembershipService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
@Service
public class MembershipPlanServiceImpl implements MembershipService {

    @Autowired
    MembershippRepository membershippRepository;

    private static final Logger logger= LoggerFactory.getLogger(MembershipPlanServiceImpl.class);
    @Override
    public List<MembershipEntity> getallMemerships() {
        return membershippRepository.getallMemberships();
    }

    @Override
    public MembershipEntity addMembership(MembershipDto membershipDto) {
            MembershipEntity addmembership= MembershipConverter.toEntity(membershipDto);
            membershippRepository.createMembership(addmembership);
            return addmembership;
    }


    @Override
    public void deleteMembership(long id) {

            membershippRepository.deleteMembershipType(id);
    }
}
