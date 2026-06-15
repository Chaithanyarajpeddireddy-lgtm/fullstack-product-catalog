//package com.catalog.repository.mongo;
//
//import com.catalog.model.mongo.User;
//import org.springframework.context.annotation.Profile;
//import org.springframework.data.mongodb.repository.MongoRepository;
//import org.springframework.stereotype.Repository;
//
//import java.util.Optional;
//
//@Profile("mongo")
//@Repository
//public interface MongoUserRepository extends MongoRepository<User, String> {
//    Optional<User> findByUsername(String username);
//    boolean existsByUsername(String username);
//}


package com.catalog.repository.mongo;

import com.catalog.model.mongo.MongoUser;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface MongoUserRepository extends MongoRepository<MongoUser, String> {

    Optional<MongoUser> findByUsername(String username);

}