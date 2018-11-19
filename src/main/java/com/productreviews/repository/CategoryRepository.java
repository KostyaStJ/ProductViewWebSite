package com.productreviews.repository;

import com.productreviews.entities.Category;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class CategoryRepository
{
	private List<Category> categories = new ArrayList<>();

	public List<Category> getCategories()
	{
		return categories;
	}
}
