//package com.catalog.repository.mongo;
//
//import com.catalog.model.mongo.Category;
//import org.springframework.context.annotation.Profile;
//import org.springframework.data.mongodb.repository.MongoRepository;
//import org.springframework.stereotype.Repository;
//
//import java.util.Optional;
//
//@Profile("mongo")
//@Repository
//public interface MongoCategoryRepository extends MongoRepository<Category, String> {
//    Optional<Category> findByName(String name);
//    boolean existsByName(String name);
//}


//package com.catalog.repository.mongo;
//
//import com.catalog.model.mongo.MongoCategory;
//
//import java.util.List;
//import java.util.Optional;
//
//public interface MongoCategoryRepository extends MongoRepository<MongoCategory, String> {
//    Optional<MongoCategory> findByName(String name);
//
//    List<MongoCategory> findAll();
//
//    Optional<MongoCategory> findById(String id);
//
//    MongoCategory save(MongoCategory category);
//
//    void deleteById(String id);
//}


package com.catalog.repository.mongo;

import com.catalog.model.mongo.MongoCategory;
import org.springframework.data.mongodb.repository.MongoRepository;  // ✅ missing import
import java.util.List;
import java.util.Optional;

public interface MongoCategoryRepository extends MongoRepository<MongoCategory, String> {
    Optional<MongoCategory> findByName(String name);
    // ✅ Remove manual findAll(), findById(), save(), deleteById()
    // MongoRepository already provides all of these
}