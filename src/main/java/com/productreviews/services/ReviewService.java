package com.productreviews.services;

import com.productreviews.converters.ReviewConverter;
import com.productreviews.data.ProductData;
import com.productreviews.data.ReviewData;
import com.productreviews.entities.Review;
import com.productreviews.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor

public class ReviewService {
    private final ReviewRepository reviewRepository;
    private final ReviewConverter reviewConverter;

    public void addReview(ProductData productData, ReviewData reviewData) {
        Review review = new Review();
        reviewConverter.dataToModel(reviewData, review);
        productData.getReviews().add(review);
        reviewRepository.save(review);
    }
}
