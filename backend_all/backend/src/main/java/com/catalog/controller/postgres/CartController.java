package com.catalog.controller.postgres;

import com.catalog.model.Cart;
import com.catalog.repository.postgres.CartRepository;
import com.catalog.repository.postgres.ProductRepository;
import org.springframework.context.annotation.Profile;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/cart")
@CrossOrigin(origins = "http://localhost:5173")
@Profile("postgres")
public class CartController {

    private final CartRepository cartRepository;
    private final ProductRepository productRepository;

    public CartController(CartRepository cartRepository, ProductRepository productRepository) {
        this.cartRepository = cartRepository;
        this.productRepository = productRepository;
    }

    @PostMapping("/add/{productId}")
    public ResponseEntity<Cart> addToCart(@PathVariable Long productId,
                                          @RequestParam Long userId) {
        Cart cart = cartRepository.findByUserId(userId).orElseGet(() -> {
            Cart c = new Cart();
            c.setUserId(userId);
            c.setProducts(new ArrayList<>());
            return c;
        });
        productRepository.findById(productId).ifPresent(p -> cart.getProducts().add(p));
        return ResponseEntity.ok(cartRepository.save(cart));
    }

    @GetMapping("/{userId}")
    public ResponseEntity<Cart> getCart(@PathVariable Long userId) {
        return cartRepository.findByUserId(userId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/remove/{productId}")
    public ResponseEntity<?> removeFromCart(@PathVariable Long productId,
                                            @RequestParam Long userId) {
        cartRepository.findByUserId(userId).ifPresent(cart -> {
            cart.getProducts().removeIf(p -> p.getId().equals(productId));
            cartRepository.save(cart);
        });
        return ResponseEntity.ok().build();
    }
}
