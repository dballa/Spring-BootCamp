package com.example.SpringBootCamp.demo.service.impl;


import com.example.SpringBootCamp.demo.converter.EquipmentConverter;
import com.example.SpringBootCamp.demo.dto.EquipmentDto;
import com.example.SpringBootCamp.demo.entity.EquipmentEntity;
import com.example.SpringBootCamp.demo.repository.EquipmentRepository;
import com.example.SpringBootCamp.demo.service.EquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
@Service
public class EquipmentServiceImpl implements EquipmentService {
    @Autowired
    EquipmentRepository equipmentRepository;
    @Override
    public List<EquipmentEntity> getallEquipments() {
        return equipmentRepository.getallEquipments();
    }

    @Override
    public EquipmentEntity addEquipment(EquipmentDto equipmentDto) {
       if (equipmentDto !=null){
          EquipmentEntity equipment= EquipmentConverter.ToEntity(equipmentDto);
          equipmentRepository.addEquipment(equipment);
          return equipment;
       }else{
           return null;
       }

    }

    @Override
    public void deleteEquipment(long id) {
        equipmentRepository.deleteEquipment(id);
    }

}
