package com.example.FakeCommerce.controllers;

import java.util.List;

import com.example.FakeCommerce.services.ReviewService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.FakeCommerce.schema.Review;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/reviews")
@RequiredArgsConstructor
public class ReviewController {

    private final ReviewService reviewService;

    @GetMapping
    public List<Review> getAllReviews() {
        reviewService.getAllReviews();
    }

    @PostMapping
    public Review createReview() {
        return reviewService.createReview();
    }

    @DeleteMapping("/{id}")
    public void deleteReview(@PathVariable Long id) {
        reviewService.deleteReview(id);
    }

    @GetMapping("/{id}")
    public Review getReviewById(@PathVariable Long id) {
        return  reviewService.getReviewById(id);
    }

    @GetMapping("/product/{productId}")
    public List<Review> getReviewsByProductId(@PathVariable Long productId) {
        return reviewService.getReviewsByProductId(productId);
    }

    @GetMapping("/order/{orderId}")
    public List<Review> getReviewsByOrderId(@PathVariable Long orderId) {
        return reviewService.getReviewsByOrderId(orderId);
    }
}
