package com.example.SpringBootCamp.demo.repository;


import com.example.SpringBootCamp.demo.entity.EquipmentEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Transactional
@Repository
public class EquipmentRepository {
    @Autowired
    private EntityManager entityManager;


    public void addEquipment( EquipmentEntity equipment){entityManager.persist(equipment);
    }
public List<EquipmentEntity> getallEquipments(){
        return entityManager.createQuery("Select equipment.ToolName,equipment.psc from EquipmentEntity equipment", EquipmentEntity.class).getResultList();}

public void deleteEquipment(long equipment){
        entityManager.remove(equipment);}
}


