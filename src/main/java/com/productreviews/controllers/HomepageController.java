package com.productreviews.controllers;

import com.productreviews.data.CategoryData;
import com.productreviews.services.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

import static com.productreviews.controllers.ControllerConstants.*;


@Controller
@RequiredArgsConstructor
@RequestMapping(value = "/home")
public class HomepageController
{
    private final CategoryService categoryService;

	@GetMapping
	public String getHomepage(Model model)
	{
        List<CategoryData> categories = categoryService.getCategories();
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

    @RequestMapping(value = "/{categoryId}", method = RequestMethod.POST)
    public String deleteCategory(@PathVariable Integer categoryId, Model model) {
        categoryService.deleteCategory(categoryId);
        return REDIRECT + HOME_URL;
    }

	@RequestMapping(value = "/thanks")
	public String getThanks()
	{
		return "thanks";
	}
}
