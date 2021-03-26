package com.ikubacademy.homework.service.reposritory;

import com.ikubacademy.homework.service.entity.EmployeeEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.swing.text.html.parser.Entity;
import java.util.List;

@Repository
@Transactional
public class EmployeeRepository {

    @Autowired
    EntityManager entityManager;

    private final String GET_ALL_EMPLOYEES = "SELECT employee from EmployeeEntity employee";
    private final String GET_EMPLOYEE = "SELECT employee from EmployeeEntity employee where employee.id = ?1";
    private final String GET_EMPLOYEE_BY_NAME_AND_JOB = "SELECT employee from EmployeeEntity employee " +
                                                                    "where employee.name = ?1 and employee.job = ?2";

    public EmployeeEntity addEmployee(EmployeeEntity employeeEntity){
        entityManager.persist(employeeEntity);
        return employeeEntity;
    }
    public boolean existsEmployee(String name,String job){
        TypedQuery<EmployeeEntity> getEmployee
                = entityManager.createQuery(GET_EMPLOYEE_BY_NAME_AND_JOB,EmployeeEntity.class);
        getEmployee.setParameter(1,name);
        getEmployee.setParameter(2,job);

        return getEmployee.getResultList().size()==1;
    }
    public EmployeeEntity getEmployee(Long id){
        TypedQuery<EmployeeEntity> getEmployee
                = entityManager.createQuery(GET_EMPLOYEE,EmployeeEntity.class).setParameter(1,id);
        return getEmployee.getSingleResult();
    }
    public List<EmployeeEntity> getAllEmployees(){
        return entityManager.createQuery(GET_ALL_EMPLOYEES,EmployeeEntity.class).getResultList();
    }

}
