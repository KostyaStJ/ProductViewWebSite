package com.productreviews.entities;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Product
{
	@Id
	@GeneratedValue
	@Column(name = "product_id")
	private Integer id;

	@ManyToOne
	private Category category;

	private String name;
	private Double price;
	private String description;

	@OneToMany
	private List<Review> reviews;
}
