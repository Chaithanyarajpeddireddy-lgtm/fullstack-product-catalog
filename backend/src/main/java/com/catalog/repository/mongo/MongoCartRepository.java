//package com.catalog.repository.mongo;
//
//import com.catalog.model.mongo.Cart;
//import org.springframework.context.annotation.Profile;
//import org.springframework.data.mongodb.repository.MongoRepository;
//import org.springframework.stereotype.Repository;
//
//import java.util.Optional;
//
//@Profile("mongo")
//@Repository
//public interface MongoCartRepository extends MongoRepository<Cart, String> {
//    Optional<Cart> findByUserId(String userId);
//}

//
//package com.catalog.repository.mongo;
//
//import com.catalog.model.mongo.MongoCart;
//import java.util.Optional;
//
//public interface MongoCartRepository extends MongoRepository<MongoCart, String> {
//    Optional<MongoCart> findByUserId(String userId);
//
//    MongoCart save(MongoCart cart);
//}


package com.catalog.repository.mongo;

import com.catalog.model.mongo.MongoCart;
import org.springframework.data.mongodb.repository.MongoRepository;  // ✅ missing import
import java.util.Optional;

public interface MongoCartRepository extends MongoRepository<MongoCart, String> {
    Optional<MongoCart> findByUserId(String userId);
    // ✅ Remove manual save() — MongoRepository already provides it
}