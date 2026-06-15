package com.catalog.controller.mongo;

import com.catalog.model.mongo.Cart;
import com.catalog.service.mongo.MongoCartService;
import org.springframework.context.annotation.Profile;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cart")
@CrossOrigin(origins = "http://localhost:5173")
@Profile("mongo")
public class MongoCartController {

    private final MongoCartService cartService;

    public MongoCartController(MongoCartService cartService) {
        this.cartService = cartService;
    }

    @PostMapping("/add/{productId}")
    public ResponseEntity<Cart> addToCart(@PathVariable String productId,
                                          @RequestParam String userId) {
        return ResponseEntity.ok(cartService.addProductToCart(userId, productId));
    }

    @GetMapping("/{userId}")
    public ResponseEntity<Cart> getCart(@PathVariable String userId) {
        return ResponseEntity.ok(cartService.getCart(userId));
    }

    @DeleteMapping("/remove/{productId}")
    public ResponseEntity<?> removeFromCart(@PathVariable String productId,
                                            @RequestParam String userId) {
        cartService.removeProductFromCart(userId, productId);
        return ResponseEntity.ok().build();
    }
}
