package com.catalog.service;

import com.catalog.model.Cart;
import com.catalog.model.Product;
import com.catalog.repository.CartRepository;
import com.catalog.repository.ProductRepository;
import org.springframework.stereotype.Service;
import java.util.ArrayList;

@Service
public class CartService {
    private final CartRepository cartRepository;
    private final ProductRepository productRepository;

    public CartService(CartRepository cartRepository, ProductRepository productRepository) {
        this.cartRepository = cartRepository;
        this.productRepository = productRepository;
    }

    public Cart addProductToCart(Long userId, Long productId) {
        Cart cart = cartRepository.findByUserId(userId).orElseGet(() -> {
            Cart newCart = new Cart();
            newCart.setUserId(userId);
            newCart.setProducts(new ArrayList<>());
            return newCart;
        });

        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        cart.getProducts().add(product);
        return cartRepository.save(cart);
    }

    public Cart getCart(Long userId) {
        return cartRepository.findByUserId(userId)
                .orElseThrow(() -> new RuntimeException("Cart not found"));
    }

    public void removeProductFromCart(Long userId, Long productId) {
        Cart cart = getCart(userId);
        cart.getProducts().removeIf(p -> p.getId().equals(productId));
        cartRepository.save(cart);
    }
}
