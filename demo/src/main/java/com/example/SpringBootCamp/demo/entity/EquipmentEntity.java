package com.example.SpringBootCamp.demo.entity;

import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
@NoArgsConstructor
@ToString
@Entity
@Table(name = "equipment", schema = "public")
@NamedQuery(name="equipment.delete", query = "delete from EquipmentEntity equipment  where equipment.id=?1")
public class EquipmentEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false,name = "tool_name")
    private String ToolName;

    @Column(nullable = false)
    private Long psc;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getToolName() {
        return ToolName;
    }

    public void setToolName(String toolName) {
        ToolName = toolName;
    }

    public Long getPsc() {
        return psc;
    }

    public void setPsc(Long psc) {
        this.psc = psc;
    }
}
