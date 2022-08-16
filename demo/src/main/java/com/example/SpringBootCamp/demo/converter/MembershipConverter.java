package com.example.SpringBootCamp.demo.converter;

import com.example.SpringBootCamp.demo.dto.MembershipDto;
import com.example.SpringBootCamp.demo.entity.MembershipEntity;


public class MembershipConverter {
    public static MembershipDto toDto(MembershipEntity membership){
        MembershipDto toReturn=new MembershipDto();
        toReturn.setId(membership.getId());
        toReturn.setMembership(membership.getMembership());
        toReturn.setCount(membership.getCount());
        toReturn.setFee(membership.getFee());
        return toReturn;

    }
    public static MembershipEntity toEntity(MembershipDto membershipDto){
        MembershipEntity toReturn=new MembershipEntity();
        toReturn.setId(membershipDto.getId());
        toReturn.setMembership(membershipDto.getMembership());
        toReturn.setCount(membershipDto.getCount());
        toReturn.setFee(membershipDto.getFee());
        return toReturn;
    }
}
