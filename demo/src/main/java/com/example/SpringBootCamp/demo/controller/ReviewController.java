package com.example.SpringBootCamp.demo.controller;

import com.example.SpringBootCamp.demo.dto.ReviewDto;
import com.example.SpringBootCamp.demo.entity.ReviewEntity;
import com.example.SpringBootCamp.demo.service.ReviewService;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
public class ReviewController {
    @Autowired
    ReviewService reviewService;
    @ApiOperation("Adding a review")
    @PostMapping("/addReview")
    public ReviewEntity addReview(@RequestBody ReviewDto review){
        return reviewService.saveReview(review);
    }
    @ApiOperation("Getting all reviews")
    @GetMapping("/getAllReviews")
    public List<ReviewEntity> findAllReviews(){
        return reviewService.getReviews();

    }
    @ApiOperation("Getting reviews by Id")
    @GetMapping("/reviewsbyId/{id}")
    public List<ReviewEntity> findReviewsById(@PathVariable Long id){
        return  reviewService.getReviewsByid(id);
    }
    @ApiOperation("Getting reviews by validity")
    @GetMapping("/reviewsbyValidity/{valid}")
    public List<ReviewEntity> findgoodReviews(@PathVariable Boolean valid ){
        return reviewService.getReviewByValidity(valid);
    }

    @ApiOperation("Deleting a review")
    @DeleteMapping("/deleteReview/{id}")
    public void deleteReview(@PathVariable Long id){
         reviewService.deleteReviews(id);

    }
    @ApiOperation("Updating Validity")
    @PutMapping("/updateValidity")
    public ReviewEntity updateReview(@RequestBody ReviewEntity review){
        return reviewService.updateReview(review);
    }
    @GetMapping("/pagination/{pageno}/{pageSize}")
    public List<ReviewEntity> getReviewPagination(@PathVariable int pageno, @PathVariable int pageSize){
     return reviewService.findallreviewswithPagination(pageno,pageSize);
    }
}
