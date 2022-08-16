package com.example.SpringBootCamp.demo.service;

import com.example.SpringBootCamp.demo.dto.EquipmentDto;
import com.example.SpringBootCamp.demo.entity.EquipmentEntity;
import org.springframework.stereotype.Service;

import java.util.List;

public interface EquipmentService {
    List<EquipmentEntity> getallEquipments();
    EquipmentEntity addEquipment(EquipmentDto equipmentDto);
    void deleteEquipment(long id);
}
