package com.ikub.salaryCalculator;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface SalaryRepository extends JpaRepository<SalaryEntity, Long> {
    List<SalaryEntity> findAllBy();

}
