package com.example.SpringBootCamp.demo.service;

import com.example.SpringBootCamp.demo.dto.MembershipInfoDto;
import com.example.SpringBootCamp.demo.entity.MembershipInfoEntity;

public interface UserMembershipService {
    MembershipInfoEntity addUserMemb(MembershipInfoDto membership);
    MembershipInfoEntity findDatesByid(Long id);
    void deleteUserMemb(Long id);
}
