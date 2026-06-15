////package com.catalog.controller.postgres;
////
////import com.catalog.model.Cart;
////import com.catalog.repository.postgres.CartRepository;
////import com.catalog.repository.postgres.ProductRepository;
////import org.springframework.context.annotation.Profile;
////import org.springframework.http.ResponseEntity;
////import org.springframework.web.bind.annotation.*;
////
////import java.util.ArrayList;
////
////@RestController
////@RequestMapping("/api/cart")
////@CrossOrigin(origins = "http://localhost:5173")
////@Profile("postgres")
////public class CartController {
////
////    private final CartRepository cartRepository;
////    private final ProductRepository productRepository;
////
////    public CartController(CartRepository cartRepository, ProductRepository productRepository) {
////        this.cartRepository = cartRepository;
////        this.productRepository = productRepository;
////    }
////
////    @PostMapping("/add/{productId}")
////    public ResponseEntity<Cart> addToCart(@PathVariable Long productId,
////                                          @RequestParam Long userId) {
////        Cart cart = cartRepository.findByUserId(userId).orElseGet(() -> {
////            Cart c = new Cart();
////            c.setUserId(userId);
////            c.setProducts(new ArrayList<>());
////            return c;
////        });
////        productRepository.findById(productId).ifPresent(p -> cart.getProducts().add(p));
////        return ResponseEntity.ok(cartRepository.save(cart));
////    }
////
////    @GetMapping("/{userId}")
////    public ResponseEntity<Cart> getCart(@PathVariable Long userId) {
////        return cartRepository.findByUserId(userId)
////                .map(ResponseEntity::ok)
////                .orElse(ResponseEntity.notFound().build());
////    }
////
////    @DeleteMapping("/remove/{productId}")
////    public ResponseEntity<?> removeFromCart(@PathVariable Long productId,
////                                            @RequestParam Long userId) {
////        cartRepository.findByUserId(userId).ifPresent(cart -> {
////            cart.getProducts().removeIf(p -> p.getId().equals(productId));
////            cartRepository.save(cart);
////        });
////        return ResponseEntity.ok().build();
////    }
//
////}
//
////
////package com.catalog.controller.postgres;
////
////import com.catalog.model.postgres.Cart;
////import com.catalog.model.postgres.Product;
////import com.catalog.repository.postgres.CartRepository;
////import com.catalog.repository.postgres.ProductRepository;
////import com.catalog.repository.postgres.UserRepository;
////import org.springframework.context.annotation.Profile;
////import org.springframework.http.ResponseEntity;
////import org.springframework.web.bind.annotation.*;
////
////@RestController
////@RequestMapping("/api/cart")
////@Profile("postgres")
////public class CartController {
////
////    private final CartRepository cartRepository;
////    private final ProductRepository productRepository;
////    private final UserRepository userRepository;
////
////    public CartController(CartRepository cartRepository,
////                          ProductRepository productRepository,
////                          UserRepository userRepository) {
////        this.cartRepository = cartRepository;
////        this.productRepository = productRepository;
////        this.userRepository = userRepository;
////    }
////
////    @GetMapping("/{userId}")
////    public ResponseEntity<Cart> getCart(@PathVariable Long userId) {
////        return cartRepository.findByUserId(userId)
////                .map(ResponseEntity::ok)
////                .orElse(ResponseEntity.notFound().build());
////    }
////
////    @PostMapping("/{userId}/add/{productId}")
////    public ResponseEntity<Cart> addToCart(@PathVariable Long userId,
////                                          @PathVariable Long productId) {
////        Cart cart = cartRepository.findByUserId(userId).orElseGet(() -> {
////            Cart newCart = new Cart();
////            newCart.setUserId(userRepository.findById(userId)
////                    .orElseThrow(() -> new RuntimeException("User not found")));
////            return cartRepository.save(newCart);
////        });
////        Product product = productRepository.findById(productId)
////                .orElseThrow(() -> new RuntimeException("Product not found"));
////        cart.getProducts().add(product);
////        return ResponseEntity.ok(cartRepository.save(cart));
////    }
////
////    @DeleteMapping("/{userId}/remove/{productId}")
////    public ResponseEntity<Cart> removeFromCart(@PathVariable Long userId,
////                                               @PathVariable Long productId) {
////        return cartRepository.findByUserId(userId).map(cart -> {
////            cart.getProducts().removeIf(p -> p.getId().equals(productId));
////            return ResponseEntity.ok(cartRepository.save(cart));
////        }).orElse(ResponseEntity.notFound().build());
////    }
////
////    @DeleteMapping("/{userId}/clear")
////    public ResponseEntity<Void> clearCart(@PathVariable Long userId) {
////        cartRepository.findByUserId(userId).ifPresent(cart -> {
////            cart.getProducts().clear();
////            cartRepository.save(cart);
////        });
////        return ResponseEntity.noContent().build();
////    }
////}
//
//
//
//package com.catalog.controller.postgres;
//
//import com.catalog.model.postgres.Cart;
//import com.catalog.model.postgres.Product;
//import com.catalog.repository.postgres.CartRepository;
//import com.catalog.repository.postgres.ProductRepository;
//import com.catalog.repository.postgres.UserRepository;
//import org.springframework.context.annotation.Profile;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping("/api/cart")
//@Profile("postgres")
//public class CartController {
//
//    private final CartRepository cartRepository;
//    private final ProductRepository productRepository;
//    private final UserRepository userRepository;
//
//    public CartController(CartRepository cartRepository,
//                          ProductRepository productRepository,
//                          UserRepository userRepository) {
//        this.cartRepository = cartRepository;
//        this.productRepository = productRepository;
//        this.userRepository = userRepository;
//    }
//
//    @GetMapping("/{userId}")
//    public ResponseEntity<Cart> getCart(@PathVariable Long userId) {
//        return cartRepository.findByUserId(userId)
//                .map(ResponseEntity::ok)
//                .orElse(ResponseEntity.notFound().build());
//    }
//
//    @PostMapping("/{userId}/add/{productId}")
//    public ResponseEntity<Cart> addToCart(@PathVariable Long userId,
//                                          @PathVariable Long productId) {
//        Cart cart = cartRepository.findByUserId(userId).orElseGet(() -> {
//            Cart newCart = new Cart();
//            newCart.setUser(userRepository.findById(userId)   // ✅ setUser() instead of setUserId()
//                    .orElseThrow(() -> new RuntimeException("User not found")));
//            return cartRepository.save(newCart);
//        });
//        Product product = productRepository.findById(productId)
//                .orElseThrow(() -> new RuntimeException("Product not found"));
//        cart.getProducts().add(product);
//        return ResponseEntity.ok(cartRepository.save(cart));
//    }
//
//    @DeleteMapping("/{userId}/remove/{productId}")
//    public ResponseEntity<Cart> removeFromCart(@PathVariable Long userId,
//                                               @PathVariable Long productId) {
//        return cartRepository.findByUserId(userId).map(cart -> {
//            cart.getProducts().removeIf(p -> p.getId().equals(productId));
//            return ResponseEntity.ok(cartRepository.save(cart));
//        }).orElse(ResponseEntity.notFound().build());
//    }
//
//    @DeleteMapping("/{userId}/clear")
//    public ResponseEntity<Void> clearCart(@PathVariable Long userId) {
//        cartRepository.findByUserId(userId).ifPresent(cart -> {
//            cart.getProducts().clear();
//            cartRepository.save(cart);
//        });
//        return ResponseEntity.noContent().build();
//    }
//}





package com.catalog.controller.postgres;

import com.catalog.model.postgres.Cart;
import com.catalog.model.postgres.Product;
import com.catalog.repository.postgres.CartRepository;
import com.catalog.repository.postgres.ProductRepository;
import com.catalog.repository.postgres.UserRepository;
import org.springframework.context.annotation.Profile;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/cart")
@Profile("postgres")
public class CartController {

    private final CartRepository cartRepository;
    private final ProductRepository productRepository;
    private final UserRepository userRepository;

    public CartController(CartRepository cartRepository,
                           ProductRepository productRepository,
                           UserRepository userRepository) {
        this.cartRepository = cartRepository;
        this.productRepository = productRepository;
        this.userRepository = userRepository;
    }

    private Cart getOrCreateCart(Long userId) {
        return cartRepository.findByUserId(userId).orElseGet(() -> {
            Cart cart = new Cart();
            cart.setUser(userRepository.findById(userId)
                    .orElseThrow(() -> new RuntimeException("User not found")));
            cart.setProducts(new ArrayList<>());
            return cartRepository.save(cart);
        });
    }

    @GetMapping("/{userId}")
    public ResponseEntity<Cart> getCart(@PathVariable Long userId) {
        return ResponseEntity.ok(getOrCreateCart(userId));
    }

    @PostMapping("/add/{productId}")
    public ResponseEntity<Cart> addToCart(@PathVariable Long productId,
                                           @RequestParam Long userId,
                                           @RequestParam(defaultValue = "1") Integer qty) {
        Cart cart = getOrCreateCart(userId);
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found"));
        if (cart.getProducts().stream().noneMatch(p -> p.getId().equals(productId))) {
            cart.getProducts().add(product);
        }
        return ResponseEntity.ok(cartRepository.save(cart));
    }

    @PostMapping("/remove/{productId}")
    public ResponseEntity<Cart> removeFromCart(@PathVariable Long productId,
                                                @RequestParam Long userId) {
        Cart cart = getOrCreateCart(userId);
        cart.getProducts().removeIf(p -> p.getId().equals(productId));
        return ResponseEntity.ok(cartRepository.save(cart));
    }

    @PostMapping("/set/{productId}")
    public ResponseEntity<Cart> setQty(@PathVariable Long productId,
                                        @RequestParam Long userId,
                                        @RequestParam Integer qty) {
        Cart cart = getOrCreateCart(userId);
        if (qty <= 0) {
            cart.getProducts().removeIf(p -> p.getId().equals(productId));
        } else if (cart.getProducts().stream().noneMatch(p -> p.getId().equals(productId))) {
            productRepository.findById(productId).ifPresent(cart.getProducts()::add);
        }
        return ResponseEntity.ok(cartRepository.save(cart));
    }

    @PostMapping("/clear")
    public ResponseEntity<Void> clearCart(@RequestParam Long userId) {
        Cart cart = getOrCreateCart(userId);
        cart.getProducts().clear();
        cartRepository.save(cart);
        return ResponseEntity.noContent().build();
    }
}