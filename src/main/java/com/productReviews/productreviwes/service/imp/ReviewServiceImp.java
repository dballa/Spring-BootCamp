package com.productReviews.productreviwes.service.imp;

import com.productReviews.productreviwes.entity.ProductEntity;
import com.productReviews.productreviwes.entity.ReviewEntity;
import com.productReviews.productreviwes.exception.ProductException;
import com.productReviews.productreviwes.exception.ReviewException;
import com.productReviews.productreviwes.repository.ProductRepository;
import com.productReviews.productreviwes.repository.ReviewRepository;
import com.productReviews.productreviwes.service.ReviewService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@AllArgsConstructor
public class ReviewServiceImp implements ReviewService {

    private final ReviewRepository reviewRepository;
    private final ProductRepository productRepository;

    @Override
    public void save(ReviewEntity reviewEntity, Long product_id) {
        ProductEntity productEntity = productRepository.getById(product_id);
        if(Objects.isNull(productEntity)) {
            throw new ProductException("Product with given id does not exist!");
        }else {
            reviewEntity.setProduct(productEntity);
            reviewRepository.save(reviewEntity);
        }
    }

    @Override
    public void delete(Long id) {
        ReviewEntity reviewToBeDeleted = reviewRepository.getById(id);
        if(Objects.isNull(reviewToBeDeleted)) {
            throw new ReviewException("Review does not exist!");
        }
        reviewRepository.delete(reviewToBeDeleted);
    }

    @Override
    public ReviewEntity update(ReviewEntity reviewEntity, Long product_id) {
        if(Objects.isNull(reviewRepository.getById(reviewEntity.getId()))){
            throw new ReviewException("Review does not exist!");
        } else {
            ProductEntity productRelatedToReview = productRepository.getById(product_id);
            if(Objects.isNull(productRelatedToReview)) {
                throw new ProductException("Product with id does not exist!");
            }
            reviewEntity.setProduct(productRelatedToReview);
            return reviewRepository.update(reviewEntity);
        }
    }

}
