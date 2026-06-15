package com.catalog.service.mongo;

import com.catalog.model.mongo.Product;
import com.catalog.repository.mongo.MongoProductRepository;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Profile("mongo")
public class MongoProductService {

    private final MongoProductRepository productRepository;

    public MongoProductService(MongoProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Optional<Product> getProductById(String id) {
        return productRepository.findById(id);
    }

    public List<Product> getProductsByCategory(String categoryName) {
        return productRepository.findByCategoryName(categoryName);
    }

    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    public Optional<Product> updateProduct(String id, Product details) {
        return productRepository.findById(id).map(existing -> {
            existing.setName(details.getName());
            existing.setDescription(details.getDescription());
            existing.setPrice(details.getPrice());
            existing.setImageUrl(details.getImageUrl());
            existing.setCategoryName(details.getCategoryName());
            return productRepository.save(existing);
        });
    }

    public boolean deleteProduct(String id) {
        if (productRepository.existsById(id)) {
            productRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
