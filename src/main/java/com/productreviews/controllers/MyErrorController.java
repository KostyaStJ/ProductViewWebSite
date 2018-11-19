package com.productreviews.controllers;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class MyErrorController implements ErrorController
{
	private static final String PATH = "/error";

	@Override
	public String getErrorPath()
	{
		return PATH;
	}

	@GetMapping(value = PATH)
	public String error()
	{
		return "error";
	}
}
