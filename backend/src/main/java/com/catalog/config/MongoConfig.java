//package com.catalog.config;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Profile;
//import org.springframework.data.mongodb.config.EnableMongoAuditing;
//import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
//
///**
// * Activates only when spring.profiles.active=mongo
// * Tells Spring Data to scan ONLY the mongo repository package,
// * so the JPA repositories are never touched in this profile.
// */
//@Configuration
//@Profile("mongo")
//@EnableMongoAuditing
//@EnableMongoRepositories(basePackages = "com.catalog.repository.mongo")
//public class MongoConfig {
//    // Spring Boot auto-wires MongoDB from application-mongo.properties
//}

//
//package com.catalog.config;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Profile;
//
//@Configuration
//@Profile("mongo")
//@EnableMongoRepositories(basePackages = "com.catalog.repository.mongo")
//public class MongoConfig {
//    // MongoDB repositories are enabled only when the "mongo" profile is active.
//    // Spring Boot auto-configures the MongoClient from application-mongo.properties.
//}




package com.catalog.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@Profile("mongo")
@EnableMongoRepositories(basePackages = {
	    "com.catalog.repository",
	    "com.catalog.repository.mongo"
	})
public class MongoConfig {
    // MongoDB repositories are enabled only when the "mongo" profile is active.
    // Spring Boot auto-configures the MongoClient from application-mongo.properties.
}
