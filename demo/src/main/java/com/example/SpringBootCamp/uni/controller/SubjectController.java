package com.example.SpringBootCamp.uni.controller;

import com.example.SpringBootCamp.uni.converter.SubjectConverter;
import com.example.SpringBootCamp.uni.dto.SubjectDto;
import com.example.SpringBootCamp.uni.dto.SubjectDtoForCreate;
import com.example.SpringBootCamp.uni.entity.SubjectEntity;
import com.example.SpringBootCamp.uni.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController()
@RequestMapping("subject")
public class SubjectController {

    @Autowired
    SubjectService subjectService;

    @DeleteMapping("{id}")
    public void delete(@PathVariable long id) {
        subjectService.delete(id);
    }

    @PostMapping()
    public SubjectDto add(@RequestBody SubjectDtoForCreate subjectDtoForCreate) {
        return SubjectConverter.toDto(subjectService.add(subjectDtoForCreate));
    }

    @GetMapping()
    public List<SubjectDto> getList() {
        List<SubjectDto> resultList=new ArrayList<>();
        for (SubjectEntity subjectEntity : subjectService.getList()) {
            resultList.add(SubjectConverter.toDto(subjectEntity));
        }
        return resultList;
    }

    @PostMapping("/testTransaction")
    public void testTransaction() {
    }

}