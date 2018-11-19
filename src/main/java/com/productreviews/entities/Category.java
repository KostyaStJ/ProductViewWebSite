package com.productreviews.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Category
{
	private Integer id;
	private String name;
	private String description;
	private final List<Product> products = new ArrayList<>();
}
