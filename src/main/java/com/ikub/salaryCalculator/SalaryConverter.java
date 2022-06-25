package com.ikub.salaryCalculator;

import org.springframework.stereotype.Component;

@Component
public class SalaryConverter {

    public SalaryDto toDto(SalaryEntity entity) {

        SalaryDto dto = new SalaryDto();
        dto.setGrossSalary(entity.getGrossSalary());
        dto.setNetSalary(entity.getNetSalary());
        return dto;
    }

    public SalaryEntity toEntity(SalaryDto dto) {
        SalaryEntity entity = new SalaryEntity();
        entity.setGrossSalary(dto.getGrossSalary());
        entity.setNetSalary(dto.getNetSalary());;
        return entity;
    }

    public NetSalaryDto toNetSalaryDto(SalaryEntity entity){
        NetSalaryDto dto = new NetSalaryDto();
        dto.setNetSalary(entity.getNetSalary());
        return dto;
    }


}
