package com.example.SpringBootCamp.demo.service;

import com.example.SpringBootCamp.demo.dto.TrainerDto;
import com.example.SpringBootCamp.demo.dto.TrainerFilter;
import com.example.SpringBootCamp.demo.dto.TrainerRelDto;
import com.example.SpringBootCamp.demo.entity.TrainerEntity;
import com.example.SpringBootCamp.demo.entity.TrainerRelEntity;

import java.util.List;

public interface TrainerService {
    List<TrainerEntity> getallTrainers(TrainerFilter filter);
    TrainerEntity addTrainer(TrainerDto trainerDto);
    void deleteTrainer(Long id);
    List<TrainerRelEntity> getallRelations();
    TrainerRelEntity addTrainertoUser(TrainerRelDto trainerRelDto);
}
