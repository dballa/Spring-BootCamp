package com.example.SpringBootCamp.uni.service.impl;

import com.example.SpringBootCamp.uni.dto.SubjectDtoForCreate;
import com.example.SpringBootCamp.uni.entity.ProfessorEntity;
import com.example.SpringBootCamp.uni.entity.SubjectEntity;
import com.example.SpringBootCamp.uni.exceptions.CustomException;
import com.example.SpringBootCamp.uni.repository.ProfessorRepository;
import com.example.SpringBootCamp.uni.repository.SubjectRepository;
import com.example.SpringBootCamp.uni.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectServiceImpl implements SubjectService {
    @Autowired
    SubjectRepository subjectRepository;
    @Autowired
    ProfessorRepository professorRepository;

    @Override
    public List<SubjectEntity> getList() {
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
        if(subject.isActive()){
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
}
