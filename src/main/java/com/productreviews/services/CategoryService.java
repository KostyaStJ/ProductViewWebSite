package com.productreviews.services;

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

    public void addCategory(Category category) {
        Category categoryEntity = new Category(category.getName(), category.getDescription());
        categoryRepository.save(categoryEntity);

    }

    public List<Category> getCategories() {
        Iterable<Category> categoryIterable = categoryRepository.findAll();
        List<Category> categoryList = new ArrayList<>();
        categoryIterable.forEach(categoryList::add);
        return categoryList;
    }

}
