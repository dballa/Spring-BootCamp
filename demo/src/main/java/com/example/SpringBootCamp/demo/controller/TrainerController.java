package com.example.SpringBootCamp.demo.controller;


import com.example.SpringBootCamp.demo.converter.TrainerConverter;
import com.example.SpringBootCamp.demo.converter.TrainerRelConverter;
import com.example.SpringBootCamp.demo.dto.TrainerDto;
import com.example.SpringBootCamp.demo.dto.TrainerFilter;
import com.example.SpringBootCamp.demo.dto.TrainerRelDto;
import com.example.SpringBootCamp.demo.service.TrainerService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
public class TrainerController {

    @Autowired
    TrainerService trainerService;



    @ApiOperation(value = "Adding a new user")
    @PostMapping("/trainer")
    public ResponseEntity<TrainerDto> addTrainer(@Valid @RequestBody TrainerDto trainerDto){
        return new ResponseEntity<>(TrainerConverter.toDto(trainerService.addTrainer(trainerDto)), HttpStatus.CREATED);
    }

    @ApiOperation(value = "Getting a list of users")
    @GetMapping("/alltrainers")
    public ResponseEntity<List<TrainerDto>> getTrainers(@RequestParam (required = false)String firstName,
                                                        @RequestParam(required = false) String lastName,
                                                        @RequestParam(required = false) String sortBy,
                                                        @RequestParam(required = false) String orderBy){
        List<TrainerDto> toReturn=new ArrayList<>();
        TrainerFilter filter=new TrainerFilter(firstName,lastName,sortBy,orderBy);
        trainerService.getallTrainers(filter).forEach(trainerEntity -> toReturn.add(TrainerConverter.toDto(trainerEntity)));
        return new ResponseEntity<List<TrainerDto>>(toReturn,HttpStatus.OK);
    }


    @ApiOperation(value="Deleting trainer")
    @DeleteMapping("/removedtrainer/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTrainer(@PathVariable long id){trainerService.deleteTrainer(id);}

    @ApiOperation(value = "Getting a list of users and the trainers")
    @GetMapping("/userstrainers")
    public ResponseEntity<List<TrainerRelDto>> getRelations(){
        List<TrainerRelDto> toReturn=new ArrayList<TrainerRelDto>();
        trainerService.getallRelations().forEach(trainerRel -> toReturn.add(TrainerRelConverter.toDto(trainerRel)));
        return new ResponseEntity<List<TrainerRelDto>>(toReturn,HttpStatus.OK);
    }

}
