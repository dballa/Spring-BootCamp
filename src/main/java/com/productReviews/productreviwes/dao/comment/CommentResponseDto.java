package com.productReviews.productreviwes.dao.comment;

import com.productReviews.productreviwes.entity.ReviewEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CommentResponseDto {
    private String comment;
    private ReviewEntity review;
}
