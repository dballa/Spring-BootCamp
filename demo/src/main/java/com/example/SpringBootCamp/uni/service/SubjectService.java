package com.example.SpringBootCamp.uni.service;

import com.example.SpringBootCamp.uni.dto.SubjectDtoForCreate;
import com.example.SpringBootCamp.uni.entity.SubjectEntity;

import java.util.List;

public interface SubjectService {
    SubjectEntity add(SubjectDtoForCreate subject);

    void delete(long id) ;

    List<SubjectEntity> getList();

}
