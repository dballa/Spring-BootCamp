package com.example.SpringBootCamp.demo.repository;


import com.example.SpringBootCamp.demo.dto.TrainerFilter;
import com.example.SpringBootCamp.demo.entity.TrainerEntity;
import com.example.SpringBootCamp.demo.entity.TrainerRelEntity;
import com.example.SpringBootCamp.demo.exceptions.UserException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@Transactional
@Repository
public class TrainerRepository {
    private static final String GET_RELATIONS="Select user.firstName, user.lastName,user.membershipId, trainerr.name from UserEntity user inner join TrainerRelEntity trainer on user.membershipId=trainer.user_id inner join TrainerEntity trainerr on trainer.trainer_id=trainerr.id";
    @Autowired
    EntityManager entityManager;

    public void addTrainer(TrainerEntity trainer){
        entityManager.persist(trainer);
    }

    public void deleteTrainer(Long trainer){
        entityManager.remove(trainer);
    }

    public void updateTrainer(TrainerEntity trainer) {
        entityManager.merge(trainer);
    }

    public List<TrainerEntity> getallTrainers(TrainerFilter filter){
        String queryString = "Select trainer from TrainerEntity trainer where 1=1";
        if (filter.getFirstName() != null && !filter.getFirstName().isEmpty()) {
            queryString = queryString + "and trainer.firstName=:firstName ";
        }
        if (filter.getLastName() != null && !filter.getLastName().isEmpty()) {
            queryString = queryString + " and trainer.lastName=:lastName ";
        }
        if (filter.getSortBy() != null && !filter.getSortBy().isEmpty()) {
            if (filter.getSortBy().equals("firstName") || filter.getSortBy().equals("lastName")){
                queryString = queryString + " order by trainer." + filter.getSortBy();
            } else {
                throw new UserException("Sort by must be firstName or lastName");
            }}
        if (filter.getOrder() != null && !filter.getSortBy().isEmpty() && filter.getSortBy() != null
                && !filter.getSortBy().isEmpty()) {
            if (filter.getOrder().toUpperCase().equals("ASC") || filter.getOrder().toUpperCase().equals("DESC")) {
                queryString = queryString + " " + filter.getOrder();
            } else {
                throw new UserException("Order  must be ASC or DESC");}
            }    TypedQuery<TrainerEntity> query = entityManager.createQuery(queryString, TrainerEntity.class);

            if (filter.getFirstName() != null && !filter.getFirstName().isEmpty()) {
                query.setParameter("firstName", filter.getFirstName());

            }
            if (filter.getLastName() != null && !filter.getLastName().isEmpty()) {
                query.setParameter("lastName", filter.getLastName());}
                return query.getResultList();}


    public List<TrainerRelEntity> getallRelations(){
        TypedQuery<TrainerRelEntity> query = entityManager.createNamedQuery(GET_RELATIONS,TrainerRelEntity.class);
        return query.getResultList();
    }
}
