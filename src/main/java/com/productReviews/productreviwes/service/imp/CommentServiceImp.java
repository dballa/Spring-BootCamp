package com.productReviews.productreviwes.service.imp;

import com.productReviews.productreviwes.entity.CommentEntity;
import com.productReviews.productreviwes.entity.ReviewEntity;
import com.productReviews.productreviwes.exception.CommentException;
import com.productReviews.productreviwes.exception.ReviewException;
import com.productReviews.productreviwes.repository.CommentRepository;
import com.productReviews.productreviwes.repository.ReviewRepository;
import com.productReviews.productreviwes.service.CommentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@AllArgsConstructor
public class CommentServiceImp implements CommentService {

    private final CommentRepository commentRepository;
    private final ReviewRepository reviewRepository;

    @Override
    public void save(CommentEntity commentEntity, Long reviewId) {
        ReviewEntity reviewToBeAddedComment = reviewRepository.getById(reviewId);
        if (Objects.isNull(reviewToBeAddedComment)) {
            throw new ReviewException("Review does not exist!");
        }
        commentEntity.setReview(reviewToBeAddedComment);
        commentRepository.save(commentEntity);
    }

    @Override
    public void delete(Long id) {
        CommentEntity commentToBeDeleted = commentRepository.getById(id);
        if (Objects.isNull(commentToBeDeleted)) {
            throw new CommentException("Comment does not exist!");
        }
        commentRepository.delete(commentToBeDeleted);
    }

    @Override
    public CommentEntity update(CommentEntity commentEntity, Long reviewId) {
        ReviewEntity reviewComment = reviewRepository.getById(reviewId);
        if(Objects.isNull(reviewComment)) {
            throw new ReviewException("Review does not exist!");
        }
        commentEntity.setReview(reviewComment);
        return commentRepository.update(commentEntity);
    }
}
