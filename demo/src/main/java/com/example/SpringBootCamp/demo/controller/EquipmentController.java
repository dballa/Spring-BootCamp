package com.example.SpringBootCamp.demo.controller;

import com.example.SpringBootCamp.demo.converter.EquipmentConverter;
import com.example.SpringBootCamp.demo.dto.EquipmentDto;
import com.example.SpringBootCamp.demo.service.EquipmentService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
public class EquipmentController {
    @Autowired
    EquipmentService equipmentService;

    @DeleteMapping("/equipment/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteEquipment(@PathVariable long id){equipmentService.deleteEquipment(id);
    }
    @ApiOperation(value = "Add a new equipment")
    @PostMapping("/equipment")
    public ResponseEntity<EquipmentDto> addUser(@Valid @RequestBody EquipmentDto equipmentDto) {

        return new ResponseEntity<>(EquipmentConverter.toDto(equipmentService.addEquipment(equipmentDto)), HttpStatus.CREATED);
    }

    @GetMapping("getallequipment")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<EquipmentDto>> getEquipments(){
        List<EquipmentDto> toReturn = new ArrayList<EquipmentDto>();
        equipmentService.getallEquipments().forEach(equipmentEntity -> toReturn.add(EquipmentConverter.toDto(equipmentEntity)));
        return new ResponseEntity<List<EquipmentDto>>(toReturn,HttpStatus.OK);
    }



}
