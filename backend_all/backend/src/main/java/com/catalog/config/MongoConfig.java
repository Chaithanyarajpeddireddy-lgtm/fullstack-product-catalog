package com.catalog.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

/**
 * Activates only when spring.profiles.active=mongo
 * Tells Spring Data to scan ONLY the mongo repository package,
 * so the JPA repositories are never touched in this profile.
 */
@Configuration
@Profile("mongo")
@EnableMongoAuditing
@EnableMongoRepositories(basePackages = "com.catalog.repository.mongo")
public class MongoConfig {
    // Spring Boot auto-wires MongoDB from application-mongo.properties
}
