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

import java.util.Optional;

import static com.productreviews.controllers.ControllerConstants.HOME_URL;
import static com.productreviews.controllers.ControllerConstants.REDIRECT;


@Controller
@RequiredArgsConstructor
@RequestMapping(value = "/categories")
public class CategoryController
{

	private final CategoryService categoryService;

	@GetMapping(value = "/{categoryId}")
	public String getCategory(@PathVariable Integer categoryId, Model model)
	{
        Optional<CategoryData> category = categoryService.getCategories().stream()
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

    @RequestMapping(value = "/{categoryId}/delete", method = RequestMethod.POST)
    public String deleteCategory(@PathVariable Integer categoryId, Model model) {
        categoryService.deleteCategory(categoryId);
        return REDIRECT + HOME_URL;
    }


}
