package com.ikubacademy.homework.service.converter;

import com.ikubacademy.homework.service.dto.EmployeeDto;
import com.ikubacademy.homework.service.dto.EmployeeDtoForCreate;
import com.ikubacademy.homework.service.dto.HolidayDto;
import com.ikubacademy.homework.service.dto.HolidayDtoForCreate;
import com.ikubacademy.homework.service.entity.EmployeeEntity;
import com.ikubacademy.homework.service.entity.HolidayEntity;

public class HolidayConverter {

    public static HolidayEntity toEntityForCreate(HolidayDtoForCreate holidayDto, EmployeeEntity employeeEntity){
        HolidayEntity entity = new HolidayEntity();
        entity.setDaySpan(holidayDto.getDaySpan());
        entity.setEmployeeEntity(employeeEntity);
        return entity;
    }
    public static HolidayDto toDto(HolidayEntity holidayEntity){
        HolidayDto holidayDto = new HolidayDto();
        holidayDto.setId(holidayEntity.getId());
        holidayDto.setDaySpan(holidayEntity.getDaySpan());
        holidayDto.setEmployeeEntity(holidayEntity.getEmployeeEntity());
        return holidayDto;
    }

}
