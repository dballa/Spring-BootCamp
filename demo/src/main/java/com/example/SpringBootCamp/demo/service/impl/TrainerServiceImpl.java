package com.example.SpringBootCamp.demo.service.impl;

import com.example.SpringBootCamp.demo.converter.TrainerConverter;
import com.example.SpringBootCamp.demo.dto.TrainerDto;
import com.example.SpringBootCamp.demo.dto.TrainerFilter;
import com.example.SpringBootCamp.demo.dto.TrainerRelDto;
import com.example.SpringBootCamp.demo.entity.TrainerEntity;
import com.example.SpringBootCamp.demo.entity.TrainerRelEntity;
import com.example.SpringBootCamp.demo.repository.TrainerRepository;
import com.example.SpringBootCamp.demo.service.TrainerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TrainerServiceImpl implements TrainerService {
    @Autowired
    TrainerRepository trainerRepository;
    private static final Logger logger = LoggerFactory.getLogger(TrainerServiceImpl.class);

    @Override
    public List<TrainerEntity> getallTrainers(TrainerFilter filter) {

        return trainerRepository.getallTrainers(filter);
    }

    @Override
    public TrainerEntity addTrainer(TrainerDto trainer) {
        if (trainer != null) {
            TrainerEntity trainerEntity = TrainerConverter.toEntity(trainer);
            trainerRepository.addTrainer(trainerEntity);
            return trainerEntity;
        } else {
            logger.warn("An error has occurred");
        }
        return null;
    }

    @Override
    public void deleteTrainer(Long id) {
        trainerRepository.deleteTrainer(id);

    }

    @Override
    public List<TrainerRelEntity> getallRelations() {
        return trainerRepository.getallRelations();
    }

    @Override
    public TrainerRelEntity addTrainertoUser(TrainerRelDto trainerRelDto) {
        return null;
    }
}
