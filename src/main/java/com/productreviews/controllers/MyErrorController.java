package com.productreviews.controllers;

import org.springframework.boot.autoconfigure.web.servlet.error.AbstractErrorController;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;


@Controller
public class MyErrorController extends AbstractErrorController
{
	private static final String PATH = "/error";

    public MyErrorController(ErrorAttributes errorAttributes) {
        super(errorAttributes);
    }

	@Override
	public String getErrorPath()
	{
		return PATH;
	}

	@GetMapping(value = PATH)
    public String error(HttpServletRequest request, Model model) {
        model.addAttribute("errors", getErrorAttributes(request, true));
		return "error";
	}
}
