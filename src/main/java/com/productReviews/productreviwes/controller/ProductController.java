package com.productReviews.productreviwes.controller;

import com.productReviews.productreviwes.converter.CommentConverter;
import com.productReviews.productreviwes.converter.ProductConverter;
import com.productReviews.productreviwes.converter.ReviewConverter;
import com.productReviews.productreviwes.dao.comment.CommentCreateDto;
import com.productReviews.productreviwes.dao.comment.CommentResponseDto;
import com.productReviews.productreviwes.dao.comment.CommentUpdateDto;
import com.productReviews.productreviwes.dao.review.ReviewResponseDto;
import com.productReviews.productreviwes.dao.product.ProductCreateDto;
import com.productReviews.productreviwes.dao.product.ProductResponseDto;
import com.productReviews.productreviwes.dao.product.ProductUpdateDto;
import com.productReviews.productreviwes.dao.review.ReviewCreateDto;
import com.productReviews.productreviwes.dao.review.ReviewUpdateDto;
import com.productReviews.productreviwes.entity.ProductEntity;
import com.productReviews.productreviwes.service.CommentService;
import com.productReviews.productreviwes.service.ProductService;
import com.productReviews.productreviwes.service.ReviewService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;
    private final ReviewService reviewService;
    private final CommentService commentService;

    @PostMapping("/create")
    public void create(@RequestBody ProductCreateDto productCreateDto) {
        productService.save(ProductConverter.convertDtoToProductEntity(productCreateDto));
    }

    @GetMapping("/all")
    public List<ProductResponseDto> all() {
        List<ProductResponseDto> response = new ArrayList<>();
        for(ProductEntity productEntity : productService.all()) {
            response.add(ProductConverter.convertProductEntityToResponseDto(productEntity));
        }
        return response;
    }

    @GetMapping("/{id}")
    public ProductResponseDto getById(@PathVariable Long id) {
        return ProductConverter.convertProductEntityToResponseDto(productService.getById(id));
    }

    @DeleteMapping("/delete/{id}")
    private void delete(@PathVariable Long id) {
        productService.delete(id);
    }

    @PutMapping("/update")
    private ProductResponseDto update(@RequestBody ProductUpdateDto productUpdateDto) {
        return ProductConverter.convertProductEntityToResponseDto(productService.update(ProductConverter.convertUpdateDtoToEntity(productUpdateDto)));
    }

    @PostMapping("/review/create")
    public void createReview(@RequestBody ReviewCreateDto reviewCreateDto) {
        reviewService.save(ReviewConverter.convertCreateDtoToReviewEntity(reviewCreateDto), reviewCreateDto.getProductId());
    }

    @DeleteMapping("/review/delete/{id}")
    public void deleteReview(@PathVariable Long id) {
        reviewService.delete(id);
    }

    @PutMapping("/review/update")
    public ReviewResponseDto updateReview(@RequestBody ReviewUpdateDto reviewUpdateDto) {
        return ReviewConverter.convertEntityToReviewResponseDto(reviewService.update(ReviewConverter.convertUpdateDtoToEntity(reviewUpdateDto), reviewUpdateDto.getProductId()));
    }

    @PostMapping("/review/comment/create")
    public void createComment(@RequestBody CommentCreateDto commentCreateDto) {
        commentService.save(CommentConverter.convertCreateDtoToEntity(commentCreateDto), commentCreateDto.getReviewId());
    }

    @DeleteMapping("/review/comment/delete/{id}")
    public void deleteComment(@PathVariable Long id) {
        commentService.delete(id);
    }

    @PutMapping("/review/comment/update")
    public CommentResponseDto updateComment(@RequestBody CommentUpdateDto commentUpdateDto) {
        return CommentConverter.convertEntityToResponseDto(commentService.update(CommentConverter.convertUpdateDtoToEntity(commentUpdateDto), commentUpdateDto.getReviewId()));
    }

}

