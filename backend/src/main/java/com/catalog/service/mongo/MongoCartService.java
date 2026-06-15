//package com.catalog.service.mongo;
//
//import com.catalog.model.mongo.Cart;
//import com.catalog.model.mongo.Product;
//import com.catalog.repository.mongo.MongoCartRepository;
//import com.catalog.repository.mongo.MongoProductRepository;
//import org.springframework.context.annotation.Profile;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//
//@Service
//@Profile("mongo")
//public class MongoCartService {
//
//    private final MongoCartRepository cartRepository;
//    private final MongoProductRepository productRepository;
//
//    public MongoCartService(MongoCartRepository cartRepository,
//                            MongoProductRepository productRepository) {
//        this.cartRepository = cartRepository;
//        this.productRepository = productRepository;
//    }
//
//    public Cart addProductToCart(String userId, String productId) {
//        // Find or create the cart for this user
//        Cart cart = cartRepository.findByUserId(userId).orElseGet(() -> {
//            Cart newCart = new Cart();
//            newCart.setUserId(userId);
//            newCart.setProducts(new ArrayList<>());
//            return newCart;
//        });
//
//        Product product = productRepository.findById(productId)
//                .orElseThrow(() -> new RuntimeException("Product not found: " + productId));
//
//        cart.getProducts().add(product);
//        return cartRepository.save(cart);
//    }
//
//    public Cart getCart(String userId) {
//        return cartRepository.findByUserId(userId)
//                .orElseThrow(() -> new RuntimeException("Cart not found for user: " + userId));
//    }
//
//    public void removeProductFromCart(String userId, String productId) {
//        Cart cart = getCart(userId);
//        cart.getProducts().removeIf(p -> p.getId().equals(productId));
//        cartRepository.save(cart);
//    }
//}


//
//package com.catalog.service.mongo;
//
//import com.catalog.model.mongo.MongoCart;
//import com.catalog.model.mongo.MongoProduct;
//import com.catalog.repository.mongo.MongoCartRepository;
//import com.catalog.repository.mongo.MongoProductRepository;
//import org.springframework.context.annotation.Profile;
//import org.springframework.stereotype.Service;
//
//import java.util.Collection;
//import java.util.Optional;
//
//@Service
//@Profile("mongo")
//public class MongoCartService {
//
//    private final MongoCartRepository cartRepository;
//    private final MongoProductRepository productRepository;
//
//    public MongoCartService(MongoCartRepository cartRepository,
//                            MongoProductRepository productRepository) {
//        this.cartRepository = cartRepository;
//        this.productRepository = productRepository;
//    }
//
//    public MongoCart getOrCreateCart(String userId) {
//        return cartRepository.findByUserId(userId)
//                .orElseGet(() -> {
//                    MongoCart cart = new MongoCart();
//                    cart.setUserId(userId);
//                    return cartRepository.save(cart);
//                });
//    }
//
//    public MongoCart addProductToCart(String userId, String productId) {
//        MongoCart cart = getOrCreateCart(userId);
//        MongoProduct product = productRepository.findById(productId)
//                .orElseThrow(() -> new RuntimeException("Product not found: " + productId));
//        cart.getProducts().addAll((Collection<?>) product);
//        return cartRepository.save(cart);
//    }
//
//    public MongoCart removeProductFromCart(String userId, String productId) {
//        MongoCart cart = getOrCreateCart(userId);
//        cart.getProducts().removeIf(p -> p.getId().equals(productId));
//        return cartRepository.save(cart);
//    }
//
//    public MongoCartRepository getCartRepository() {
//		return cartRepository;
//	}
//
//	public MongoProductRepository getProductRepository() {
//		return productRepository;
//	}
//
//	public void clearCart(String userId) {
//        cartRepository.findByUserId(userId).ifPresent(cart -> {
//            cart.getProducts().clear();
//            cartRepository.save(cart);
//        });
//    }
//}
//

//
//package com.catalog.service.mongo;
//
//import com.catalog.model.mongo.MongoCart;
//import com.catalog.model.mongo.MongoProduct;
//import com.catalog.repository.mongo.MongoCartRepository;
//import com.catalog.repository.mongo.MongoProductRepository;
//import org.springframework.context.annotation.Profile;
//import org.springframework.stereotype.Service;
//
//@Service
//@Profile("mongo")
//public class MongoCartService {
//
//    private final MongoCartRepository cartRepository;
//    private final MongoProductRepository productRepository;
//
//    public MongoCartService(MongoCartRepository cartRepository,
//                            MongoProductRepository productRepository) {
//        this.cartRepository = cartRepository;
//        this.productRepository = productRepository;
//    }
//
//    public MongoCart getOrCreateCart(String userId) {
//        return cartRepository.findByUserId(userId)
//                .orElseGet(() -> {
//                    MongoCart cart = new MongoCart();
//                    cart.setUserId(userId);
//                    return cartRepository.save(cart);
//                });
//    }
//
//    public MongoCart addProductToCart(String userId, String productId) {
//        MongoCart cart = getOrCreateCart(userId);
//        MongoProduct product = productRepository.findById(productId)
//                .orElseThrow(() -> new RuntimeException("Product not found: " + productId));
//        ((Object) cart.getProducts()).add(product);  // ✅ List<MongoProduct> now supports add()
//        return cartRepository.save(cart);
//    }
//
//    public MongoCart removeProductFromCart(String userId, String productId) {
//        MongoCart cart = getOrCreateCart(userId);
//        cart.getProducts().removeIf(p -> p.getId().equals(productId));  // ✅ removeIf works on List
//        return cartRepository.save(cart);
//    }
//
//    public void clearCart(String userId) {
//        cartRepository.findByUserId(userId).ifPresent(cart -> {
//            cart.getProducts().clear();  // ✅ clear() works on List
//            cartRepository.save(cart);
//        });
//    }
//}
package com.catalog.service.mongo;

import com.catalog.model.mongo.MongoCart;
import com.catalog.model.mongo.MongoProduct;
import com.catalog.repository.mongo.MongoCartRepository;
import com.catalog.repository.mongo.MongoProductRepository;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("mongo")
public class MongoCartService {

    private final MongoCartRepository cartRepository;
    private final MongoProductRepository productRepository;

    public MongoCartService(MongoCartRepository cartRepository,
                            MongoProductRepository productRepository) {
        this.cartRepository = cartRepository;
        this.productRepository = productRepository;
    }

    public MongoCart getOrCreateCart(String userId) {
        return cartRepository.findByUserId(userId)
                .orElseGet(() -> {
                    MongoCart cart = new MongoCart();
                    cart.setUserId(userId);
                    return cartRepository.save(cart);
                });
    }

    public MongoCart addProductToCart(String userId, String productId) {
        MongoCart cart = getOrCreateCart(userId);
        MongoProduct product = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found: " + productId));
        cart.getProducts().add(product);  // ✅ correct
        return cartRepository.save(cart);
    }

    public MongoCart removeProductFromCart(String userId, String productId) {
        MongoCart cart = getOrCreateCart(userId);
        cart.getProducts().removeIf(p -> p.getId().equals(productId));
        return cartRepository.save(cart);
    }

    public void clearCart(String userId) {
        cartRepository.findByUserId(userId).ifPresent(cart -> {
            cart.getProducts().clear();
            cartRepository.save(cart);
        });
    }
}