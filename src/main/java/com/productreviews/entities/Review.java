package com.productreviews.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Review
{
	@Id
	@GeneratedValue
	private Integer reviewId;

	@JoinColumn(name = "product_id")
	private Integer productId;

	private String text;
}
