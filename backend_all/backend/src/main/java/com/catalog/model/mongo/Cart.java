package com.catalog.model.mongo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.context.annotation.Profile;

import java.util.ArrayList;
import java.util.List;

@Profile("mongo")
@Document(collection = "carts")
public class Cart {

    @Id
    private String id;

    // Indexed so we can quickly find a cart by user
    @Indexed(unique = true)
    private String userId;

    // Products are embedded directly — no join table, no foreign key
    private List<Product> products = new ArrayList<>();

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getUserId() { return userId; }
    public void setUserId(String userId) { this.userId = userId; }

    public List<Product> getProducts() { return products; }
    public void setProducts(List<Product> products) { this.products = products; }
}
