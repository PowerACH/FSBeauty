package com.example.powercosm.repositories;

import com.example.powercosm.models.Cart;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface CartRepository extends CrudRepository<Cart, Long> {
    @Query("FROM Cart c WHERE c.prodName = ?1")
    public Cart findByName(String prodName);

    @Query("SELECT SUM(c.price) FROM Cart c")
    public double getTotal();

}