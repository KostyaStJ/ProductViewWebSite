package com.productreviews.services;

import com.productreviews.entities.Product;
import com.productreviews.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public Product getById(Integer id) {
        Product product;
        Optional<Product> optionalProduct = productRepository.findById(id);

        if (optionalProduct.isPresent()) {
            product = optionalProduct.get();
            return product;
        } else {
            return null;
        }
    }

    public void add(Product product) {
        productRepository.save(product);
    }

    public void addAll(Iterable<Product> productIterable) {
        productRepository.saveAll(productIterable);
    }

}
