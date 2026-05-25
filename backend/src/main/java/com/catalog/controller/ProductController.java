//package com.catalog.controller;
//
//import com.catalog.model.Product;
//import com.catalog.repository.ProductRepository;
//import org.springframework.web.bind.annotation.*;
//import java.util.List;
//
//@RestController
//@RequestMapping("/api/products")
//@CrossOrigin(origins = "http://localhost:5173")
//public class ProductController {
//
//    private final ProductRepository productRepository;
//
//    public ProductController(ProductRepository productRepository) {
//        this.productRepository = productRepository;
//    }
//
//    // ✅ Public endpoints for frontend
//    @GetMapping
//    public List<Product> getAllProducts() {
//        return productRepository.findAll();
//    }
//
//    @GetMapping("/category/{categoryName}")
//    public List<Product> getProductsByCategory(@PathVariable String categoryName) {
//        return productRepository.findByCategoryName(categoryName);
//    }
//
//    // 🔒 Keep these for Swagger/SQL use only
//    @PostMapping
//    public Product createProduct(@RequestBody Product product) {
//        return productRepository.save(product);
//    }
//
//    @PutMapping("/{id}")
//    public Product updateProduct(@PathVariable Long id, @RequestBody Product productDetails) {
//        return productRepository.findById(id)
//                .map(product -> {
//                    product.setName(productDetails.getName());
//                    product.setDescription(productDetails.getDescription());
//                    product.setPrice(productDetails.getPrice());
//                    product.setCategory(productDetails.getCategory());
//                    return productRepository.save(product);
//                })
//                .orElseThrow(() -> new RuntimeException("Product not found"));
//    }
//
//    @DeleteMapping("/{id}")
//    public void deleteProduct(@PathVariable Long id) {
//        productRepository.deleteById(id);
//    }
//    
//    
//    @GetMapping("/{id}")
//    public ResponseEntity<Product> getProductById(@PathVariable Long id) {
//        return productRepository.findById(id)
//                .map(ResponseEntity::ok)
//                .orElse(ResponseEntity.notFound().build());
//    }
//
//}










package com.catalog.controller;

import com.catalog.model.Product;
import com.catalog.repository.ProductRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@CrossOrigin(origins = "http://localhost:5173")
public class ProductController {

    private final ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    // ✅ Get all products
    @GetMapping
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    // ✅ Get product by ID (fix for 403 issue)
    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id) {
        return productRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // ✅ Get products by category name
    @GetMapping("/category/{categoryName}")
    public List<Product> getProductsByCategory(@PathVariable String categoryName) {
        return productRepository.findByCategoryName(categoryName);
    }

    // 🔒 Admin/Swagger use only
    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        return productRepository.save(product);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody Product productDetails) {
        return productRepository.findById(id)
                .map(product -> {
                    product.setName(productDetails.getName());
                    product.setDescription(productDetails.getDescription());
                    product.setPrice(productDetails.getPrice());
                    product.setCategory(productDetails.getCategory());
                    return ResponseEntity.ok(productRepository.save(product));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable Long id) {
        return productRepository.findById(id)
                .map(product -> {
                    productRepository.delete(product);
                    return ResponseEntity.ok().build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}

