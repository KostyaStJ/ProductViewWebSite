package com.productreviews.controllers;


import com.productreviews.services.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import static com.productreviews.controllers.ControllerConstants.HOME_URL;
import static com.productreviews.controllers.ControllerConstants.REDIRECT;


@Controller
@RequiredArgsConstructor
@RequestMapping(value = "/home")
public class HomepageController
{
    private final CategoryService categoryService;


    @GetMapping
    public String getHomepage() {
        return REDIRECT + HOME_URL;
    }



	@RequestMapping(value = "/thanks")
	public String getThanks()
	{
		return "thanks";
	}
}
