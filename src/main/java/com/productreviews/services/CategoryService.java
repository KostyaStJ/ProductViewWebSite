package com.productreviews.services;

import com.productreviews.converters.CategoryConverter;
import com.productreviews.data.CategoryData;
import com.productreviews.entities.Category;
import com.productreviews.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;
    private final CategoryConverter categoryConverter;

    public CategoryData getById(Integer id) {
        CategoryData categoryData = new CategoryData();
        Optional<Category> categoryOptional = categoryRepository.findById(id);
        if (categoryOptional.isPresent()) {
            categoryConverter.modelToData(categoryOptional.get(), categoryData);
            return categoryData;
        } else {
            return null;
        }
    }

    public void addCategory(CategoryData categoryData) {
        Category categoryEntity = new Category();
        categoryConverter.dataToModel(categoryData, categoryEntity);
        categoryRepository.save(categoryEntity);
    }

    public void deleteCategory(Integer id) {
        categoryRepository.deleteById(id);
    }

    public List<CategoryData> getCategories() {
        Iterable<Category> categoryIterable = categoryRepository.findAll();

        List<CategoryData> categoriesData = new ArrayList<>();
        for (Category category : categoryIterable) {
            CategoryData categoryData = new CategoryData();
            categoryConverter.modelToData(category, categoryData);
            categoriesData.add(categoryData);
        }

        return categoriesData;
    }

    public void editCategory(Integer categoryId, CategoryData categoryData) {
        Category category = categoryRepository.findById(categoryId).get();
        category.setName(categoryData.getName());
        category.setDescription(categoryData.getDescription());
        categoryRepository.save(category);
    }



}
