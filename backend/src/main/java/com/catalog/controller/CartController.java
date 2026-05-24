package com.catalog.controller;

import com.catalog.model.Cart;
import com.catalog.service.CartService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cart")
public class CartController {
    private final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @PostMapping("/add/{productId}")
    public ResponseEntity<Cart> addToCart(@PathVariable Long productId, @RequestParam Long userId) {
        return ResponseEntity.ok(cartService.addProductToCart(userId, productId));
    }

    @GetMapping("/{userId}")
    public ResponseEntity<Cart> getCart(@PathVariable Long userId) {
        return ResponseEntity.ok(cartService.getCart(userId));
    }

    @DeleteMapping("/remove/{productId}")
    public ResponseEntity<?> removeFromCart(@PathVariable Long productId, @RequestParam Long userId) {
        cartService.removeProductFromCart(userId, productId);
        return ResponseEntity.ok().build();
    }
}
