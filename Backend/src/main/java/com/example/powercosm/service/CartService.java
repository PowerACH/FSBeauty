package com.example.powercosm.service;

import com.example.powercosm.models.Cart;
import org.springframework.http.HttpStatus;

public interface CartService {

    public Cart createCart(Cart newCart);

    public Iterable<Cart> listCart();

    public Cart getCart(String prodName);

    public HttpStatus deleteById(Long prodId);

    double getTotal();
}