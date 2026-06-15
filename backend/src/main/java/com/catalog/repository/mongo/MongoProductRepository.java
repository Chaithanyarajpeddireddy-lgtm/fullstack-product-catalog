//package com.catalog.repository.mongo;
//
//import com.catalog.model.mongo.Product;
//import org.springframework.context.annotation.Profile;
//import org.springframework.data.mongodb.repository.MongoRepository;
//import org.springframework.stereotype.Repository;
//
//import java.util.List;
//
//@Profile("mongo")
//@Repository
//public interface MongoProductRepository extends MongoRepository<Product, String> {
//    // Spring Data auto-generates the query from the method name — same as JPA
//    List<Product> findByCategoryName(String categoryName);
//    List<Product> findByNameContainingIgnoreCase(String name);
//}


//package com.catalog.repository.mongo;
//
//import com.catalog.model.mongo.MongoProduct;
//import java.util.List;
//import java.util.Optional;
//
//import org.springframework.context.annotation.Profile;
//import org.springframework.stereotype.Repository;
//
//@Profile("mongo")
//@Repository
//public interface MongoProductRepository extends MongoRepository<MongoProduct, String> {
//    List<MongoProduct> findByCategoryName(String categoryName);
//
//    void deleteById(String id);
//
//    Optional<MongoProduct> findById(String id);
//
//    MongoProduct save(MongoProduct existing);
//
//    List<MongoProduct> findAll();
//}


package com.catalog.repository.mongo;

import com.catalog.model.mongo.MongoProduct;
import org.springframework.data.mongodb.repository.MongoRepository;  // ✅ missing import
import org.springframework.context.annotation.Profile;
import java.util.List;

@Profile("mongo")
public interface MongoProductRepository extends MongoRepository<MongoProduct, String> {
    List<MongoProduct> findByCategoryName(String categoryName);
    // ✅ Remove findAll(), findById(), save(), deleteById() — already in MongoRepository
}
