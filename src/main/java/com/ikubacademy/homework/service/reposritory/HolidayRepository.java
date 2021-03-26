package com.ikubacademy.homework.service.reposritory;

import com.ikubacademy.homework.service.entity.HolidayEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
@Transactional
public class HolidayRepository {
    @Autowired
    private EntityManager entityManager;

    private static final String GET_ALL_HOLIDAYS = "SELECT holiday from HolidayEntity holiday";
    private static final String GET_HOLIDAY_OF_EMPLOYEE = "SELECT holiday from HolidayEntity holiday " +
                                                                                "join holiday.employeeEntity e where e.id = ?1";

    private static final String GET_AVERAGE_DAY_SPAN_OF_HOLIDAYS = "SELECT AVG(holiday.daySpan) from HolidayEntity holiday";
    private static final String GET_AVERAGE_DAY_SPAN_OF_HOLIDAYS_EMPLOYEE = "SELECT AVG(holiday.daySpan) from HolidayEntity holiday " +
                                                                                    "join holiday.employeeEntity e where e.id = ?1";
    private static final String GET_HOLIDAYS_OF_DEPARTMENT =
            "SELECT holiday from HolidayEntity holiday " +
                    "join holiday.employeeEntity e " +
                    "join e.departmentEntity d " +
                    "where d.id = ?1";
    private static final String GET_HOLIDAYS_OF_DEPARTMENT_DAY_CONDITION =
            "SELECT holiday from HolidayEntity holiday " +
                    "join holiday.employeeEntity e " +
                    "join e.departmentEntity d " +
                    "where d.id = ?1 and holiday.daySpan > 10";

    public HolidayEntity addHoliday(HolidayEntity holidayEntity){
        entityManager.persist(holidayEntity);
        return holidayEntity;
    }
    public Double getAverage(){
        return (Double) entityManager.createQuery(GET_AVERAGE_DAY_SPAN_OF_HOLIDAYS).getSingleResult();
    }
    public Double getAverageOfEMployee(Long id){
        return (Double) entityManager.createQuery(GET_AVERAGE_DAY_SPAN_OF_HOLIDAYS_EMPLOYEE)
                .setParameter(1,id)
                .getSingleResult();
    }
    public List<HolidayEntity> getHolidayOfEmployee(Long id){
        TypedQuery<HolidayEntity> holidaysOfEmp =
                entityManager.createQuery(GET_HOLIDAY_OF_EMPLOYEE,HolidayEntity.class).setParameter(1,id);
        return holidaysOfEmp.getResultList();
    }

    public List<HolidayEntity> getAllHolidays(){
        TypedQuery<HolidayEntity> allHolidays =
                entityManager.createQuery(GET_ALL_HOLIDAYS,HolidayEntity.class);
        return allHolidays.getResultList();
    }
    public List<HolidayEntity> getAllHolidaysOfDepartment(Long id){
        TypedQuery<HolidayEntity> allHolidays
                = entityManager.createQuery(GET_HOLIDAYS_OF_DEPARTMENT,HolidayEntity.class).setParameter(1,id);
        return allHolidays.getResultList();
    }
    public List<HolidayEntity> getAllHolidaysOfDepartmentDayCondition(Long id){
        TypedQuery<HolidayEntity> allHolidays
                = entityManager.createQuery(GET_HOLIDAYS_OF_DEPARTMENT_DAY_CONDITION,HolidayEntity.class)
                                    .setParameter(1,id);
        return allHolidays.getResultList();
    }
}
