package com.productreviews.controllers;

import com.productreviews.entities.Product;
import com.productreviews.entities.Review;
import com.productreviews.repository.ProductRepository;
import com.productreviews.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping(value = "/products")
@RequiredArgsConstructor
public class ProductController
{
	private final ProductRepository productRepository;
	private final ReviewRepository reviewRepository;

	@GetMapping(value = "/{productId}")
	public String getProduct(@PathVariable Integer productId, Model model)
	{
		Product product = productRepository.getProductById(productId);
		if (product != null)
		{
			model.addAttribute("product", product);
			model.addAttribute("review", new Review());
		}
		else
		{
			return ControllerConstants.ERROR_PAGE;
		}
		return ControllerConstants.PRODUCT_PAGE;
	}

	@PostMapping(value = "/{productId}/reviews")
	public String addReview(@PathVariable Integer productId, Review review, Model model)
	{

		Product product = productRepository.getProductById(productId);

		if (product != null)
		{
			reviewRepository.addReview(product, review);
			model.addAttribute("product", product);
			model.addAttribute("review", new Review());
		}
		else
		{
			return ControllerConstants.ERROR_PAGE;
		}
		return ControllerConstants.PRODUCT_PAGE;
	}

}
