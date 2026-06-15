package com.catalog.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * Activates only when spring.profiles.active=postgres
 * Spring Boot auto-configures JPA + DataSource from application-postgres.properties.
 * Nothing extra needed here — this class is a marker so you can see in the
 * running logs which profile is active.
 */
@Configuration
@Profile("postgres")
public class PostgresConfig {
    // Spring Boot auto-wires JPA from application-postgres.properties
}
