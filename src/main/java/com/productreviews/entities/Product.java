package com.productreviews.entities;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Product
{
	@Id

	@Column(name = "product_id")
	private Integer id;

	private String name;
	private Double price;
	private String description;

	@OneToMany
	private List<Review> reviews;
}
