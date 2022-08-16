package com.example.SpringBootCamp.demo.converter;

import com.example.SpringBootCamp.demo.dto.EquipmentDto;
import com.example.SpringBootCamp.demo.entity.EquipmentEntity;


public class EquipmentConverter {
    public static EquipmentDto toDto(EquipmentEntity equipmentEntity){
        EquipmentDto ToReturn=new EquipmentDto();
        ToReturn.setId(equipmentEntity.getId());
        ToReturn.setToolName(equipmentEntity.getToolName());
        ToReturn.setPsc(equipmentEntity.getPsc());
        return ToReturn;
    }
    public static EquipmentEntity ToEntity(EquipmentDto equipmentDto){
        EquipmentEntity toReturn=new EquipmentEntity();
        toReturn.setId(equipmentDto.getId());
        toReturn.setToolName(equipmentDto.getToolName());
        toReturn.setPsc(equipmentDto.getPsc());
        return toReturn;
    }

}
