package com.productreviews.data;

import com.productreviews.entities.Product;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Data
public class CategoryData {
    private Integer id;
    private List<Product> products;

    @NotNull
    @Size(min = 1, max = 30, message = "Wrong category name size. It must be from 1 to 30 characters")
    private String name;

    private String description;
}
