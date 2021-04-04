package com.academy.monika.restapp.controller;

import com.academy.monika.restapp.converter.SubjectConverter;
import com.academy.monika.restapp.dto.EmployeeDto;
import com.academy.monika.restapp.dto.SubjectDto;
import com.academy.monika.restapp.dto.SubjectDtoForCreate;
import com.academy.monika.restapp.entity.SubjectEntity;
import com.academy.monika.restapp.service.SubjectService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController()
@RequestMapping("subject")
public class SubjectController {

    @Autowired
    SubjectService subjectService;

    @ApiOperation(value="Delete a subject")
    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable long id) {
        subjectService.delete(id);
    }

    @ApiOperation(value="Add a subject")
    @PostMapping()
    public ResponseEntity<SubjectDto>  add(@RequestBody SubjectDtoForCreate subjectDtoForCreate) {
        return new ResponseEntity<>(SubjectConverter.toDto(subjectService.add(subjectDtoForCreate)),HttpStatus.CREATED);
    }

   /* @ApiOperation(value="Get list of subjects")
    @GetMapping()
    public ResponseEntity<List<SubjectDto>> getList(@RequestParam(required=false) Boolean active) {
        List<SubjectDto> resultList=new ArrayList<>();
        for (SubjectEntity subjectEntity : subjectService.getList(active)) {
            resultList.add(SubjectConverter.toDto(subjectEntity));
        }
        return new ResponseEntity<>(resultList, HttpStatus.OK) ;
    }*/

    @PostMapping("/testTransaction")
    public void testTransaction() {
        subjectService.testRestApi();
    }


    @GetMapping("/clientapi")
    public ResponseEntity<List<EmployeeDto>> clientApi() {
        return new ResponseEntity<>(subjectService.testRestApi(),HttpStatus.OK);
    }

    @ApiOperation(value="Get list of subjects")
    @GetMapping()
    @ResponseBody
    public ResponseEntity<List<SubjectDto>> getFilteredList(@RequestParam Map<String,String> allParams) {
        List<SubjectDto> resultList=new ArrayList<>();
        for (SubjectEntity subjectEntity : subjectService.getFilteredList(allParams)) {
            resultList.add(SubjectConverter.toDto(subjectEntity));
        }
        return new ResponseEntity<>(resultList, HttpStatus.OK) ;
    }
}