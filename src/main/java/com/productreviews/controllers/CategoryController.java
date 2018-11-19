package com.productreviews.controllers;

import com.productreviews.entities.Category;
import com.productreviews.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;


@Controller
@RequiredArgsConstructor
@RequestMapping(value = "/categories")
public class CategoryController
{
	private final CategoryRepository categoryRepository;

	@GetMapping(value = "/{categoryId}")
	public String getCategory(@PathVariable Integer categoryId, Model model)
	{
		Optional<Category> category = categoryRepository.getCategories().stream()
				.filter(cat -> cat.getId().equals(categoryId)).findAny();
		if (category.isPresent())
		{
			model.addAttribute("category", category.get());
		}
		else
		{
			return ControllerConstants.ERROR_PAGE;
		}
		return ControllerConstants.CATEGORY_PAGE;
	}
}
