package com.productreviews.controllers;

import com.productreviews.entities.Product;
import com.productreviews.entities.Review;
import com.productreviews.services.ProductService;
import com.productreviews.services.ReviewService;
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
	private final ProductService productService;
	private final ReviewService reviewService;


	@GetMapping(value = "/{productId}")
	public String getProduct(@PathVariable Integer productId, Model model)
	{
		Product product = productService.getById(productId);
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

		Product product = productService.getById(productId);

		if (product != null)
		{
			reviewService.addReview(product, review);
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
