package com.productreviews.converters;

import com.productreviews.data.ReviewData;
import com.productreviews.entities.Review;
import org.springframework.stereotype.Component;

@Component
public class ReviewConverter {
    public void dataToModel(ReviewData reviewData, Review review) {
        review.setProductId(reviewData.getProductId());
        review.setReviewId(reviewData.getReviewId());
        review.setText(reviewData.getText());
    }


    public void modelToData(ReviewData reviewData, Review review) {
        reviewData.setProductId(review.getProductId());
        reviewData.setReviewId(review.getReviewId());
        review.setText(review.getText());
    }
}
