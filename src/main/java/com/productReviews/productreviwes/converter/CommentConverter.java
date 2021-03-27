package com.productReviews.productreviwes.converter;

import com.productReviews.productreviwes.dao.comment.CommentCreateDto;
import com.productReviews.productreviwes.dao.comment.CommentResponseDto;
import com.productReviews.productreviwes.dao.comment.CommentUpdateDto;
import com.productReviews.productreviwes.entity.CommentEntity;

public class CommentConverter {

    public static CommentEntity convertCreateDtoToEntity(CommentCreateDto commentCreateDto) {
        CommentEntity commentToBeAdded = new CommentEntity();
        commentToBeAdded.setComment(commentCreateDto.getComment());
        return commentToBeAdded;
    }

    public static CommentEntity convertUpdateDtoToEntity(CommentUpdateDto commentUpdateDto) {
        CommentEntity commentToBeUpdated = new CommentEntity();
        commentToBeUpdated.setId(commentUpdateDto.getId());
        commentToBeUpdated.setComment(commentUpdateDto.getComment());
        return commentToBeUpdated;
    }

    public static CommentResponseDto convertEntityToResponseDto(CommentEntity commentEntity) {
        CommentResponseDto response = new CommentResponseDto();
        response.setComment(commentEntity.getComment());
        response.setReview(commentEntity.getReview());
        return response;
    }

}
