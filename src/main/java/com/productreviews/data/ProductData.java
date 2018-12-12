package com.productreviews.data;

import com.productreviews.entities.Category;
import com.productreviews.entities.Review;
import lombok.Data;

import java.util.List;

@Data
public class ProductData {
    private Integer id;
    private String name;
    private Double price;
    private String description;
    private Category category;
    private List<Review> reviews;

}
