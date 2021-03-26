package com.ikubacademy.homework.service.service.impl;

import com.ikubacademy.homework.service.converter.HolidayConverter;
import com.ikubacademy.homework.service.dto.HolidayDtoForCreate;
import com.ikubacademy.homework.service.entity.EmployeeEntity;
import com.ikubacademy.homework.service.entity.HolidayEntity;
import com.ikubacademy.homework.service.reposritory.EmployeeRepository;
import com.ikubacademy.homework.service.reposritory.HolidayRepository;
import com.ikubacademy.homework.service.service.HolidayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class HolidayServiceImpl implements HolidayService {
    @Autowired
    private HolidayRepository holidayRepository;
    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public HolidayEntity addHoliday(HolidayDtoForCreate holidayDtoForCreate) {
        Long empId = holidayDtoForCreate.getIdEmployee();
        EmployeeEntity employeeEntity = employeeRepository.getEmployee(empId);
        HolidayEntity holidayEntity = HolidayConverter.toEntityForCreate(holidayDtoForCreate,employeeEntity);
        return holidayRepository.addHoliday(holidayEntity);
    }

    @Override
    public List<HolidayEntity> getAllHolidays() {
        return holidayRepository.getAllHolidays();
    }

    @Override
    public List<HolidayEntity> getHolidaysOfEmployee(Long id) {
        try {
            return holidayRepository.getHolidayOfEmployee(id);
        } catch (Exception e){
            e.printStackTrace();
        }
       return null;
    }
    @Override
    public Double getAverage(){
        return holidayRepository.getAverage();
    }

    @Override
    public Double getAverageOfEmployee(Long id) {
        return holidayRepository.getAverageOfEMployee(id);
    }

    @Override
    public List<HolidayEntity> getAllHolidaysOfDepartment(Long id) {
        return holidayRepository.getAllHolidaysOfDepartment(id);
    }

    @Override
    public List<HolidayEntity> getAllHolidaysOfDepartmentDaysCondition(Long id) {
        return holidayRepository.getAllHolidaysOfDepartmentDayCondition(id);
    }
}
