package com.example.FakeCommerce.repositories;

import com.example.FakeCommerce.schema.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewsRepository extends JpaRepository<Review, Long> {


    List<Review> findByProductId(Long productId);

    List<Review> getReviewsByOrderId(Long orderId);
}
