package com.catalog.repository.mongo;

import com.catalog.model.mongo.Category;
import org.springframework.context.annotation.Profile;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Profile("mongo")
@Repository
public interface MongoCategoryRepository extends MongoRepository<Category, String> {
    Optional<Category> findByName(String name);
    boolean existsByName(String name);
}
