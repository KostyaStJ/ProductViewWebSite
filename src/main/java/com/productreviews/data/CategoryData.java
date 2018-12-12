package com.productreviews.data;

import com.productreviews.entities.Product;
import lombok.Data;

import java.util.List;

@Data
public class CategoryData {
    private Integer id;
    private List<Product> products;
    private String name;
    private String description;
}
