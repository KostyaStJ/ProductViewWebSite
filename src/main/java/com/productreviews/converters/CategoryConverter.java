package com.productreviews.converters;

import com.productreviews.data.CategoryData;
import com.productreviews.entities.Category;
import org.springframework.stereotype.Component;

@Component
public class CategoryConverter {
    public void dataToModel(CategoryData categoryData, Category category) {
        category.setName(categoryData.getName());
        category.setDescription(categoryData.getDescription());
    }

    public void modelToData(Category category, CategoryData categoryData) {
        categoryData.setId(category.getId());
        categoryData.setName(category.getName());
        categoryData.setDescription(category.getDescription());
        categoryData.setProducts(category.getProducts());
    }
}
