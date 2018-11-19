package com.productreviews.entities;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Product
{
	private Integer id;
	private String name;
	private Double price;
	private String description;
	private List<Review> reviews;
}
