package com.catalog.repository;

import com.catalog.model.Review;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ReviewRepository
        extends MongoRepository<Review, String> {
}