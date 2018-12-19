package com.productreviews.services;

import com.productreviews.converters.ReviewConverter;
import com.productreviews.data.ProductData;
import com.productreviews.data.ReviewData;
import com.productreviews.entities.Product;
import com.productreviews.entities.Review;
import com.productreviews.repository.ProductRepository;
import com.productreviews.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor

public class ReviewService {
    private final ReviewRepository reviewRepository;
    private final ReviewConverter reviewConverter;
    private final ProductRepository productRepository;

    public void addReview(ProductData productData, ReviewData reviewData) {
        Review review = new Review();
        reviewConverter.dataToModel(reviewData, review);
        productData.getReviews().add(review);
        reviewRepository.save(review);
    }

    public void deleteReview(Integer productId, Integer reviewId) {

        Optional<Product> productOptional = productRepository.findById(productId);
        Product product = productOptional.get();
        Review review = reviewRepository.findById(reviewId).get();

        product.getReviews().remove(review);

        reviewRepository.deleteById(reviewId);

    }


    public ReviewData getById(Integer id) {
        ReviewData reviewData = new ReviewData();
        Optional<Review> reviewOptional = reviewRepository.findById(id);
        if (reviewOptional.isPresent()) {
            reviewConverter.modelToData(reviewData, reviewOptional.get());
            return reviewData;
        } else {
            return null;
        }

    }
}
