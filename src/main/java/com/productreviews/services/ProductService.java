package com.productreviews.services;

import com.productreviews.converters.ProductConverter;
import com.productreviews.data.ProductData;
import com.productreviews.entities.Product;
import com.productreviews.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    private final ProductConverter productConverter;

    public ProductData getById(Integer id) {
        ProductData productData = new ProductData();
        Optional<Product> optionalProduct = productRepository.findById(id);

        if (optionalProduct.isPresent()) {
            productConverter.modelToData(productData, optionalProduct.get());
            return productData;
        } else {
            return null;
        }
    }

    public void add(ProductData productData) {
        Product product = new Product();
        productConverter.dataToModel(productData, product);
        productRepository.save(product);
    }

    public void addAll(Iterable<Product> productIterable) {
        productRepository.saveAll(productIterable);
    }

    public void deleteProduct(Integer id) {
        productRepository.deleteById(id);
    }

}
