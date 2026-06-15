//package com.catalog.model.postgres;
//
//import jakarta.persistence.*;
//import org.springframework.context.annotation.Profile;
//
//import java.util.List;
//
//@Profile("postgres")
//@Entity
//@Table(name = "cart")
//public class Cart {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    private User userId;
//
//    @ManyToMany
//    @JoinTable(
//        name = "cart_products",
//        joinColumns = @JoinColumn(name = "cart_id"),
//        inverseJoinColumns = @JoinColumn(name = "product_id")
//    )
//    private List<Product> products;
//
//    public Long getId() { return id; }
//    public void setId(Long id) { this.id = id; }
//
//    public User getUserId() { return userId; }
//    public void setUserId(User userId) { this.userId = userId; }
//
//    public List<Product> getProducts() { return products; }
//    public void setProducts(List<Product> products) { this.products = products; }
//}


package com.catalog.model.postgres;

import jakarta.persistence.*;
import org.springframework.context.annotation.Profile;
import java.util.List;

@Profile("postgres")
@Entity
@Table(name = "cart")
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne                          // ✅ tells Hibernate this is a relationship
    @JoinColumn(name = "user_id")       // ✅ maps to the foreign key column
    private User user;                  // ✅ renamed from userId (convention: userId implies a Long, not a User object)

    @ManyToMany
    @JoinTable(
        name = "cart_products",
        joinColumns = @JoinColumn(name = "cart_id"),
        inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    private List<Product> products;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }

    public List<Product> getProducts() { return products; }
    public void setProducts(List<Product> products) { this.products = products; }
}