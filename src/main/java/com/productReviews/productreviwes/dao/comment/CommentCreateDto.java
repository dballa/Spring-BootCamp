package com.productReviews.productreviwes.dao.comment;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
public class CommentCreateDto {

    private String comment;
    private Long reviewId;

}

