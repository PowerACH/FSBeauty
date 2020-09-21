package com.example.powercosm.repositories;

import com.example.powercosm.models.Skincare;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface SkincareRepository extends CrudRepository<Skincare, Long> {
    @Query("FROM Skincare p WHERE p.prodName = ?1")
    public Skincare findByName(String prodName);
}
