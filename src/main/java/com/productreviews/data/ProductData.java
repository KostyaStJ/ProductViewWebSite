package com.productreviews.data;

import com.productreviews.entities.Category;
import com.productreviews.entities.Review;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Data
public class ProductData {
    private Integer id;

    @NotNull
    @Size(min = 1, max = 50, message = "Wrong product name size. It must be from 1 to 50 characters")
    private String name;
    private Double price;
    private String description;
    private Category category;
    private List<Review> reviews;

}
