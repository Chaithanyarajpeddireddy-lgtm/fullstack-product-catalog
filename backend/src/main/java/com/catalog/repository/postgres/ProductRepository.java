package com.catalog.repository.postgres;

import com.catalog.model.postgres.Product;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Profile("postgres")
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByCategory_Name(String categoryName);
}
