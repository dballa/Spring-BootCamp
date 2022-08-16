package com.example.SpringBootCamp.demo.controller;

import com.example.SpringBootCamp.demo.converter.MembershipConverter;
import com.example.SpringBootCamp.demo.dto.MembershipDto;
import com.example.SpringBootCamp.demo.entity.MembershipEntity;
import com.example.SpringBootCamp.demo.service.impl.MembershipPlanServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
public class MembershipController {
    @Autowired
    MembershipPlanServiceImpl membershipPlanService;

    @PostMapping("/AddingMembershipPlan")
    public ResponseEntity<MembershipDto> addMembership(@Valid @RequestBody MembershipDto membershipDto){
        return new ResponseEntity<>(MembershipConverter.toDto(membershipPlanService.addMembership(membershipDto)), HttpStatus.CREATED);
    }
    public List<MembershipEntity> getAllMembershipPlans(){
        return membershipPlanService.getallMemerships();
    }
    public void deleteMembership(Long id){
        membershipPlanService.deleteMembership(id);
    }
}
