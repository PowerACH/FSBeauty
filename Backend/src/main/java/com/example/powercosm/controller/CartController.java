package com.example.powercosm.controller;

import com.example.powercosm.models.Cart;
import com.example.powercosm.repositories.CartRepository;
import com.example.powercosm.service.CartService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins="*")
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @GetMapping
    public Iterable<Cart> listCart() {
        return cartService.listCart();
    }

    @PostMapping
    public Cart createCart(@RequestBody Cart newCart) {
        return cartService.createCart(newCart);
    }

    @GetMapping("/total")
    double getTotal() { return cartService.getTotal(); }

    @GetMapping("/{prodName}")
    public Cart getCart(@PathVariable String prodName) {
        return cartService.getCart(prodName);
    }

    @DeleteMapping("/{prodId}")
    public HttpStatus deleteById(@PathVariable Long prodId) { return cartService.deleteById(prodId);}
}

