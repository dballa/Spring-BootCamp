package com.example.SpringBootCamp.demo.service;

import com.example.SpringBootCamp.demo.converter.ReviewConverter;
import com.example.SpringBootCamp.demo.dto.ReviewDto;
import com.example.SpringBootCamp.demo.entity.ReviewEntity;
import com.example.SpringBootCamp.demo.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.List;

@Service
public class ReviewService {
    @Autowired
    ReviewRepository repository;
    @Autowired
    EntityManager em;

    public ReviewEntity saveReview(ReviewDto reviewDto){
        ReviewEntity review= ReviewConverter.toEntity(reviewDto);
        repository.save(review);
        return review;
    }
    public List<ReviewEntity> getReviews(){
        return repository.findAll();
    }
    public List<ReviewEntity> getReviewsByid(Long id){
        return repository.findAllById(id);
    }
    public ReviewEntity updateReview(ReviewEntity review){
        ReviewEntity revieew=repository.findById(review.getId()).orElse(review);
        revieew.setValid(review.isValid());
        return repository.save(revieew);

    }
    public List<ReviewEntity> getReviewByValidity(Boolean valid){
        return repository.findByValid(valid);
    }
    public void deleteReviews(Long id){
        repository.deleteById(id);
    }
    public List<ReviewEntity> findallreviewswithPagination(int pageNo,int pageSize){
        return em.createQuery("Select review from ReviewEntity review",ReviewEntity.class).setFirstResult((pageNo-1)*pageSize).setMaxResults(pageSize).getResultList();
    }
}
