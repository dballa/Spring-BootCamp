package com.ikub.salaryCalculator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class SalaryService {

    @Value("${name}")
    private String profile;

    @Autowired
    private SalaryRepository salaryRepository;


    @Autowired
    private SalaryConverter salaryConverter;


    public SalaryDto calculate(SalaryDto salaryDto){

        if("dev".equalsIgnoreCase(profile)) {
            double netSalary;
            netSalary = salaryDto.getGrossSalary() * 0.91;
            SalaryDto response = new SalaryDto();
            response.setGrossSalary(salaryDto.getGrossSalary());
            response.setNetSalary(netSalary);
            return  response;
        }

        else {
            double sigurimetShendetsore;
            double sigurimetShoqerore;
            double tatimiMbiTeArdhurat;
            double pagaNeto;

            if (salaryDto.getGrossSalary()>=32000){
                sigurimetShendetsore = (1.7/100)*salaryDto.getGrossSalary();
                 sigurimetShoqerore = (9.5/100)*salaryDto.getGrossSalary();
            } else {
                sigurimetShoqerore = 0;
                sigurimetShendetsore = 0;
            }


            if (salaryDto.getGrossSalary()<=40000) {
                tatimiMbiTeArdhurat = 0;
            }
            else if (salaryDto.getGrossSalary()>=40001 && salaryDto.getGrossSalary()<=50000){
                tatimiMbiTeArdhurat =  0.5 * 0.13 * (salaryDto.getGrossSalary()-30000);

            }
            else{
                if (salaryDto.getGrossSalary()>= 30001 && salaryDto.getGrossSalary()<=200000){
                    tatimiMbiTeArdhurat =   0.13 * (salaryDto.getGrossSalary()-30000);
                }
                else{
                    tatimiMbiTeArdhurat = 22100 + 0.23 * (salaryDto.getGrossSalary()-200000);
                }
            }


            pagaNeto = salaryDto.getGrossSalary() - sigurimetShoqerore - sigurimetShendetsore - tatimiMbiTeArdhurat;
            SalaryDto response = new SalaryDto();
            SalaryEntity salaryEntity = salaryConverter.toEntity(salaryDto);
            salaryEntity.setGrossSalary(response.getGrossSalary());
            salaryEntity.setNetSalary(pagaNeto);
            return salaryConverter.toDto(salaryEntity);
        }
    }

    public SalaryDto saveToDb(SalaryDto salaryDto) {
        salaryDto.setNetSalary(calculate(salaryDto).getNetSalary());
        salaryRepository.save(salaryConverter.toEntity(salaryDto));
        return salaryDto;
    }


    public Double getNetSalariesAverage() {

        return  salaryRepository
                .findAllBy()
                .stream()
                .map(salaryConverter::toNetSalaryDto)
                .mapToDouble(NetSalaryDto::getNetSalary)
                .average()
                .orElse(Double.NaN);
    }


}