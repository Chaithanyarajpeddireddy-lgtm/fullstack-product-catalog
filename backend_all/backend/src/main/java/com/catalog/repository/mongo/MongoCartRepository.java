package com.catalog.repository.mongo;

import com.catalog.model.mongo.Cart;
import org.springframework.context.annotation.Profile;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Profile("mongo")
@Repository
public interface MongoCartRepository extends MongoRepository<Cart, String> {
    Optional<Cart> findByUserId(String userId);
}
