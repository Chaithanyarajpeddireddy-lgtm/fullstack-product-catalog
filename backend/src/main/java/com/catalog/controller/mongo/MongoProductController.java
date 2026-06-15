//package com.catalog.controller.mongo;
//
//import com.catalog.model.mongo.Product;
//import com.catalog.service.mongo.MongoProductService;
//import org.springframework.context.annotation.Profile;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/api/products")
//@CrossOrigin(origins = "http://localhost:5173")
//@Profile("mongo")
//public class MongoProductController {
//
//    private final MongoProductService productService;
//
//    public MongoProductController(MongoProductService productService) {
//        this.productService = productService;
//    }
//
//    @GetMapping
//    public List<Product> getAllProducts() {
//        return productService.getAllProducts();
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<Product> getProductById(@PathVariable String id) {
//        return productService.getProductById(id)
//                .map(ResponseEntity::ok)
//                .orElse(ResponseEntity.notFound().build());
//    }
//
//    @GetMapping("/category/{categoryName}")
//    public List<Product> getProductsByCategory(@PathVariable String categoryName) {
//        return productService.getProductsByCategory(categoryName);
//    }
//
//    @PostMapping
//    public Product createProduct(@RequestBody Product product) {
//        return productService.createProduct(product);
//    }
//
//    @PutMapping("/{id}")
//    public ResponseEntity<Product> updateProduct(@PathVariable String id,
//                                                  @RequestBody Product details) {
//        return productService.updateProduct(id, details)
//                .map(ResponseEntity::ok)
//                .orElse(ResponseEntity.notFound().build());
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<?> deleteProduct(@PathVariable String id) {
//        return productService.deleteProduct(id)
//                ? ResponseEntity.ok().build()
//                : ResponseEntity.notFound().build();
//    }
//}


package com.catalog.controller.mongo;

import com.catalog.model.mongo.MongoProduct;
import com.catalog.service.mongo.MongoProductService;
import org.springframework.context.annotation.Profile;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@Profile("mongo")
public class MongoProductController {

    private final MongoProductService productService;

    public MongoProductController(MongoProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<MongoProduct> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public ResponseEntity<MongoProduct> getProductById(@PathVariable String id) {
        return productService.getProductById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/category/{categoryName}")
    public List<MongoProduct> getProductsByCategory(@PathVariable String categoryName) {
        return productService.getProductsByCategory(categoryName);
    }

    @PostMapping
    public MongoProduct createProduct(@RequestBody MongoProduct product) {
        return productService.createProduct(product);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MongoProduct> updateProduct(@PathVariable String id,
                                                       @RequestBody MongoProduct updated) {
        return productService.updateProduct(id, updated)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable String id) {
        productService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }
}

