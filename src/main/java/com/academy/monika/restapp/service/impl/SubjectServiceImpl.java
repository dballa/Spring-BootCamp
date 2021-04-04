package com.academy.monika.restapp.service.impl;

import com.academy.monika.restapp.dto.EmployeeDto;
import com.academy.monika.restapp.dto.ResponseTestExternalAPI;
import com.academy.monika.restapp.dto.SubjectDto;
import com.academy.monika.restapp.dto.SubjectDtoForCreate;
import com.academy.monika.restapp.entity.ProfessorEntity;
import com.academy.monika.restapp.entity.SubjectEntity;
import com.academy.monika.restapp.exceptions.CustomException;
import com.academy.monika.restapp.repository.ProfessorRepository;
import com.academy.monika.restapp.repository.SubjectRepository;
import com.academy.monika.restapp.service.SubjectService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

@Service
public class SubjectServiceImpl implements SubjectService {
    @Autowired
    SubjectRepository subjectRepository;
    @Autowired
    ProfessorRepository professorRepository;
    @Autowired
    RestTemplate restTemplate;
    @Override
    public List<SubjectEntity> getList(Boolean active) {
        if(active!=null){
            return subjectRepository.getActiveList(active);
        }
       return subjectRepository.getList();
    }

    public SubjectEntity add(SubjectDtoForCreate subjectDtoForCreate) {
        if (subjectDtoForCreate != null) {
            if (subjectDtoForCreate.getCreditsCfu() < 1 && subjectDtoForCreate.getCreditsCfu() > 15) {
                throw new CustomException("The credits of a subject should be between 1-15");
            }
        }
        SubjectEntity subjectEntity = new SubjectEntity();
        subjectEntity.setName(subjectDtoForCreate.getName());
        subjectEntity.setSemester(subjectDtoForCreate.getSemester());
        return subjectEntity;
    }

    public void delete(long id) {
        SubjectEntity subject = subjectRepository.getSubjectById(id);
        if(subject==null){
            throw new CustomException("Subject not found");
        }
        if(subject.getActive()){
            throw new CustomException("Active subject can not be deleted");
        }
        subjectRepository.deleteSubject(subject);
    }

    public void addSubjectWithProfessor(SubjectEntity subjectEntity) {

        subjectRepository.addSubject(subjectEntity);
        throw new RuntimeException();
    }

    public void testTransaction() {
        ProfessorEntity professorEntity = new ProfessorEntity();
        professorEntity.setFirstName("NAME");
        professorEntity.setLastName("SURNAME");
        professorRepository.addUser(professorEntity);
        SubjectEntity subjectEntity = new SubjectEntity();
        subjectEntity.setName("Subject");
        subjectEntity.setCreditsCfu(5d);
        subjectEntity.setSemester(2);
        addSubjectWithProfessor(subjectEntity);
    }

    public List<EmployeeDto> testRestApi() {
        ResponseEntity<ResponseTestExternalAPI> response = restTemplate.exchange("https://gorest.co.in/public-api/users", HttpMethod.GET, null,
                ResponseTestExternalAPI.class);
        return response.getBody().getData();

    }

    @Override
    public List<SubjectEntity> getFilteredList(Map<String, String> allParams) {
        return subjectRepository.getFilteredList(allParams);
    }
}
