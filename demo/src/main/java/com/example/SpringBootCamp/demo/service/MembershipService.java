package com.example.SpringBootCamp.demo.service;

import com.example.SpringBootCamp.demo.dto.MembershipDto;
import com.example.SpringBootCamp.demo.entity.MembershipEntity;

import java.util.List;

public interface MembershipService {
    List<MembershipEntity>getallMemerships();
    MembershipEntity addMembership(MembershipDto membershipDto);
    void deleteMembership(long id);

}
