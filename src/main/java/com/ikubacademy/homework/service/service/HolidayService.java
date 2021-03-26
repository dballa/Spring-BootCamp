package com.ikubacademy.homework.service.service;

import com.ikubacademy.homework.service.dto.HolidayDtoForCreate;
import com.ikubacademy.homework.service.entity.HolidayEntity;

import java.util.List;

public interface HolidayService {
    HolidayEntity addHoliday(HolidayDtoForCreate holidayEntity);
    List<HolidayEntity> getAllHolidays();
    List<HolidayEntity> getHolidaysOfEmployee(Long id);
    Double getAverage();
    Double getAverageOfEmployee(Long id);
    List<HolidayEntity> getAllHolidaysOfDepartment(Long id);
    List<HolidayEntity> getAllHolidaysOfDepartmentDaysCondition(Long id);
}
