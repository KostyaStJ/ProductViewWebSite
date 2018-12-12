package com.productreviews.controllers;

import com.productreviews.data.ProductData;
import com.productreviews.data.ReviewData;
import com.productreviews.repository.CategoryRepository;
import com.productreviews.services.ProductService;
import com.productreviews.services.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import static com.productreviews.controllers.ControllerConstants.HOME_URL;
import static com.productreviews.controllers.ControllerConstants.REDIRECT;


@Controller
@RequestMapping(value = "/products")
@RequiredArgsConstructor
public class ProductController
{
	private final ProductService productService;
	private final ReviewService reviewService;
	private final CategoryRepository categoryRepository;


	@GetMapping(value = "/{productId}")
	public String getProduct(@PathVariable Integer productId, Model model)
	{
		ProductData productData = productService.getById(productId);
		if (productData != null) {
			model.addAttribute("product", productData);
			model.addAttribute("review", new ReviewData());
		}
		else
		{
			return ControllerConstants.ERROR_PAGE;
		}
		return ControllerConstants.PRODUCT_PAGE;
	}

	@PostMapping(value = "/{productId}/reviews")
	public String addReview(@PathVariable Integer productId, ReviewData reviewData, Model model) {
		ProductData productData = productService.getById(productId);

		if (productData != null) {
			reviewService.addReview(productData, reviewData);
			model.addAttribute("product", productData);
			model.addAttribute("review", new ReviewData());
		}
		else
		{
			return ControllerConstants.ERROR_PAGE;
		}
		return ControllerConstants.PRODUCT_PAGE;
	}

	@RequestMapping(value = "/{productId}", method = RequestMethod.POST)
	public String deleteProduct(@PathVariable Integer productId) {
		productService.deleteProduct(productId);
		return REDIRECT + HOME_URL;
	}

}
