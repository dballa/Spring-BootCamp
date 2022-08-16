package com.example.SpringBootCamp.demo.repository;


import com.example.SpringBootCamp.demo.entity.ReviewEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepository extends JpaRepository<ReviewEntity,Long>{

    List<ReviewEntity> findAllById(Long id);

    List<ReviewEntity> findByValid(Boolean valid);

}
