package com.productreviews.services;

import com.productreviews.converters.CategoryConverter;
import com.productreviews.data.CategoryData;
import com.productreviews.entities.Category;
import com.productreviews.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;
    private final CategoryConverter categoryConverter;


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

}
