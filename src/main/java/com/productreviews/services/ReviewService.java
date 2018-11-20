package com.productreviews.services;

import com.productreviews.entities.Product;
import com.productreviews.entities.Review;
import com.productreviews.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor

public class ReviewService {
    private final ReviewRepository reviewRepository;

    public void addReview(Product product, Review review) {
        product.getReviews().add(review);
        reviewRepository.save(review);
    }
}
