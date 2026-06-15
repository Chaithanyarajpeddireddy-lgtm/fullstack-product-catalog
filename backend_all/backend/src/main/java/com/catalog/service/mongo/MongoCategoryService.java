package com.catalog.service.mongo;

import com.catalog.model.mongo.Category;
import com.catalog.repository.mongo.MongoCategoryRepository;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Profile("mongo")
public class MongoCategoryService {

    private final MongoCategoryRepository categoryRepository;

    public MongoCategoryService(MongoCategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    public Category createCategory(Category category) {
        return categoryRepository.save(category);
    }

    public Optional<Category> updateCategory(String id, Category details) {
        return categoryRepository.findById(id).map(existing -> {
            existing.setName(details.getName());
            return categoryRepository.save(existing);
        });
    }

    public boolean deleteCategory(String id) {
        if (categoryRepository.existsById(id)) {
            categoryRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
