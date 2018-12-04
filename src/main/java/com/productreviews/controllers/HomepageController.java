package com.productreviews.controllers;

import com.productreviews.entities.Category;
import com.productreviews.services.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import static com.productreviews.controllers.ControllerConstants.ERROR_PAGE;
import static com.productreviews.controllers.ControllerConstants.HOME_PAGE;


@Controller
@RequiredArgsConstructor
@RequestMapping(value = "/home")
public class HomepageController
{
    private final CategoryService categoryService;

	@GetMapping
	public String getHomepage(Model model)
	{
		System.out.println(
				"------------------------------------------------------HOMEPAGE------------------------------------------------------");
        List<Category> categories = categoryService.getCategories();
		if (!categories.isEmpty())
		{
			model.addAttribute("categories", categories);
		}
		else
		{
			return ERROR_PAGE;
		}
		return HOME_PAGE;
	}

	@RequestMapping(value = "/thanks")
	public String getThanks()
	{
		return "thanks";
	}
}
