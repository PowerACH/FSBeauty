package com.example.powercosm.repositories;

import com.example.powercosm.models.Makeup;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface MakeupRepository extends CrudRepository<Makeup, Long> {
    @Query("FROM Makeup p WHERE p.prodName = ?1")
    public Makeup findByName(String prodName);
}