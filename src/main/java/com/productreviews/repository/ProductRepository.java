package com.productreviews.repository;

import com.productreviews.entities.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;


@Component
@RequiredArgsConstructor
public class ProductRepository
{
	private final CategoryRepository categoryRepository;

	public List<Product> getAllProducts()
	{
		return categoryRepository.getCategories().stream().flatMap(category -> category.getProducts().stream())
				.collect(Collectors.toList());
	}

	public Product getProductById(Integer productId)
	{
		return getAllProducts().stream().filter(product -> product.getId().equals(productId)).findAny().orElse(null);

	}

}
