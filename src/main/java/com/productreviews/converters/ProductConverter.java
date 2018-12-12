package com.productreviews.converters;

import com.productreviews.data.ProductData;
import com.productreviews.entities.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductConverter {
    public void dataToModel(ProductData productData, Product product) {
        product.setName(productData.getName());
        product.setDescription(productData.getDescription());
        product.setPrice(productData.getPrice());
        product.setReviews(productData.getReviews());
        product.setId(productData.getId());
        product.setCategory(productData.getCategory());
    }

    public void modelToData(ProductData productData, Product product) {
        productData.setName(product.getName());
        productData.setDescription(product.getDescription());
        productData.setPrice(product.getPrice());
        productData.setId(product.getId());
        productData.setReviews(product.getReviews());
        productData.setCategory(product.getCategory());


    }

}
