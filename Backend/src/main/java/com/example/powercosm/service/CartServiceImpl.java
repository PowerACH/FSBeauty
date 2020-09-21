package com.example.powercosm.service;

import com.example.powercosm.models.Cart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class CartServiceImpl implements CartService{

    @Autowired
    com.example.powercosm.repositories.CartRepository CartRepository;

    @Override
    public Cart createCart(Cart newCart) {
        return CartRepository.save(newCart);
    }

    @Override
    public Iterable<Cart> listCart(){
        return CartRepository.findAll();
    }

    @Override
    public double getTotal() { return CartRepository.getTotal();}

    @Override
    public Cart getCart(String prodName) {
        return CartRepository.findByName(prodName);
    }

    @Override
    public HttpStatus deleteById(Long prodId) { CartRepository.deleteById(prodId);
        return null;
    }

}