package com.productreviews.repository;

import com.productreviews.entities.Product;
import com.productreviews.entities.Review;
import org.springframework.stereotype.Component;


@Component
public class ReviewRepository
{
	public void addReview(Product product, Review review)
	{
		product.getReviews().add(review);
	}
}
