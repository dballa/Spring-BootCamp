package com.ikubacademy.homework.service.reposritory;

import com.ikubacademy.homework.service.entity.DepartmentEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
@Transactional
public class DepartmentRepository {

    @Autowired
    EntityManager entityManager;
    private final String GET_ALL_QUERY = "SELECT d from DepartmentEntity d";
    private final String GET_DEPARTMENT_WITH_NAME = "SELECT d from DepartmentEntity d where d.departmentName = :name";
    private final String GET_DEPARTMENT_WITH_ID = "SELECT d from DepartmentEntity d where d.id = :id";

    public List<DepartmentEntity> getAllEntities(){
        TypedQuery<DepartmentEntity> query = entityManager.createQuery(GET_ALL_QUERY,DepartmentEntity.class);
        return query.getResultList();
    }
    public DepartmentEntity getDepartment(String name){
        TypedQuery<DepartmentEntity> getDepWithNameQuery =
                entityManager.createQuery(GET_DEPARTMENT_WITH_NAME,DepartmentEntity.class).setParameter("name",name);
        return getDepWithNameQuery.getSingleResult();
    }
    public DepartmentEntity addDepartment(DepartmentEntity departmentEntity){
         entityManager.persist(departmentEntity);
         return departmentEntity;
    }
    public DepartmentEntity getDepartmentFromId(Long id){
        TypedQuery<DepartmentEntity> getDepWithIdQuery =
                entityManager.createQuery(GET_DEPARTMENT_WITH_ID,DepartmentEntity.class).setParameter("id",id);
        return getDepWithIdQuery.getSingleResult();
    }
    public boolean existsDepartment(Long id){
        TypedQuery<DepartmentEntity> getDepWithIdQuery =
        entityManager.createQuery(GET_DEPARTMENT_WITH_ID,DepartmentEntity.class).setParameter("id",id);
        return getDepWithIdQuery.getResultList().size() == 1;
    }
}
