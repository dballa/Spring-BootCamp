package com.ikubacademy.homework.service.controller;

import com.ikubacademy.homework.service.converter.HolidayConverter;
import com.ikubacademy.homework.service.dto.HolidayDto;
import com.ikubacademy.homework.service.dto.HolidayDtoForCreate;
import com.ikubacademy.homework.service.entity.HolidayEntity;
import com.ikubacademy.homework.service.service.HolidayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/holiday")
public class HolidayController {
    @Autowired
    private HolidayService holidayService;
    @PostMapping("/addHoliday")
    public HolidayDto addHoliday(@RequestBody HolidayDtoForCreate holidayDtoForCreate){
        return HolidayConverter.toDto(holidayService.addHoliday(holidayDtoForCreate));
    }
    @GetMapping("/getHolidayOfEmployee/{id}")
    public List<HolidayEntity> getHolidaysOfEmployee(@PathVariable Long id){
        return holidayService.getHolidaysOfEmployee(id);
    }
    @GetMapping
    public List<HolidayEntity> getAll(){
        return holidayService.getAllHolidays();
    }
    @GetMapping("/avg")
    public Double getAvg(){
        return holidayService.getAverage();
    }
    @GetMapping("/avg/{id}")
    public Double getAvg(@PathVariable Long id){
        return holidayService.getAverageOfEmployee(id);
    }
    @GetMapping("/department/{id}")
    public List<HolidayEntity> getHolidaysOfDepartent(@PathVariable Long id){
        return holidayService.getAllHolidaysOfDepartment(id);
    }
    @GetMapping("/department/days/{id}")
    public List<HolidayEntity> getHolidaysOfDepartentDaysCondtion(@PathVariable Long id){
        return holidayService.getAllHolidaysOfDepartmentDaysCondition(id);
    }
}
