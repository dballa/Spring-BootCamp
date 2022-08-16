package com.example.SpringBootCamp.demo.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class EquipmentDto {
    private Long id;
    private Long psc;
    private String ToolName;
}
