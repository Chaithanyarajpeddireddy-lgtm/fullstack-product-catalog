package com.catalog.repository.mongo;

import com.catalog.model.mongo.Product;
import org.springframework.context.annotation.Profile;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Profile("mongo")
@Repository
public interface MongoProductRepository extends MongoRepository<Product, String> {
    // Spring Data auto-generates the query from the method name — same as JPA
    List<Product> findByCategoryName(String categoryName);
    List<Product> findByNameContainingIgnoreCase(String name);
}
