package com.example.FakeCommerce.services;

import com.example.FakeCommerce.repositories.ReviewsRepository;
import com.example.FakeCommerce.schema.Review;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReviewService {

    private final ReviewsRepository reviewsRepository;


    public void getAllReviews() {
        reviewsRepository.findAll();
    }

    public Review createReview() {
        return reviewsRepository.save(new Review());
    }

    public void deleteReview(Long id) {
        reviewsRepository.deleteById(id);
    }

    public Review getReviewById(Long id) {
        return reviewsRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Review not found"));
    }

    public List<Review> getReviewsByProductId(Long productId) {
        return reviewsRepository.findByProductId(productId);
    }

    public List<Review> getReviewsByOrderId(Long orderId) {
        return reviewsRepository.getReviewsByOrderId(orderId);
    }
}
