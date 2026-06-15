//package com.catalog.controller.mongo;
//
//import com.catalog.model.mongo.Category;
//import com.catalog.service.mongo.MongoCategoryService;
//import org.springframework.context.annotation.Profile;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/api/categories")
//@CrossOrigin(origins = "http://localhost:5173")
//@Profile("mongo")
//public class MongoCategoryController {
//
//    private final MongoCategoryService categoryService;
//
//    public MongoCategoryController(MongoCategoryService categoryService) {
//        this.categoryService = categoryService;
//    }
//
//    @GetMapping
//    public List<Category> getAllCategories() {
//        return categoryService.getAllCategories();
//    }
//
//    @PostMapping
//    public Category createCategory(@RequestBody Category category) {
//        return categoryService.createCategory(category);
//    }
//
//    @PutMapping("/{id}")
//    public ResponseEntity<Category> updateCategory(@PathVariable String id,
//                                                    @RequestBody Category details) {
//        return categoryService.updateCategory(id, details)
//                .map(ResponseEntity::ok)
//                .orElse(ResponseEntity.notFound().build());
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<?> deleteCategory(@PathVariable String id) {
//        return categoryService.deleteCategory(id)
//                ? ResponseEntity.ok().build()
//                : ResponseEntity.notFound().build();
//    }
//}


package com.catalog.controller.mongo;

import com.catalog.model.mongo.MongoCategory;
import com.catalog.service.mongo.MongoCategoryService;
import org.springframework.context.annotation.Profile;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
@Profile("mongo")
public class MongoCategoryController {

    private final MongoCategoryService categoryService;

    public MongoCategoryController(MongoCategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public List<MongoCategory> getAllCategories() {
        return categoryService.getAllCategories();
    }

    @GetMapping("/{id}")
    public ResponseEntity<MongoCategory> getCategoryById(@PathVariable String id) {
        return categoryService.getCategoryById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public MongoCategory createCategory(@RequestBody MongoCategory category) {
        return categoryService.createCategory(category);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MongoCategory> updateCategory(@PathVariable String id,
                                                         @RequestBody MongoCategory updated) {
        return categoryService.updateCategory(id, updated)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable String id) {
        categoryService.deleteCategory(id);
        return ResponseEntity.noContent().build();
    }
}
