package com.academy.monika.restapp.service;

import com.academy.monika.restapp.dto.EmployeeDto;
import com.academy.monika.restapp.dto.SubjectDto;
import com.academy.monika.restapp.dto.SubjectDtoForCreate;
import com.academy.monika.restapp.entity.SubjectEntity;

import java.util.List;
import java.util.Map;

public interface SubjectService {
    SubjectEntity add(SubjectDtoForCreate subject);

    void delete(long id) ;

    List<SubjectEntity> getList(Boolean active);

    List<EmployeeDto> testRestApi();

    List<SubjectEntity> getFilteredList(Map<String, String> allParams);
}
