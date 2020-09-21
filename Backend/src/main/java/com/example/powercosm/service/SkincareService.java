package com.example.powercosm.service;

import com.example.powercosm.models.Skincare;
import org.springframework.http.HttpStatus;

public interface SkincareService {

    public Skincare createSkincare(Skincare newSkincare);

    public Iterable<Skincare> listSkincare();

    public Skincare getSkincare(String prodName);

    public HttpStatus deleteById(Long prodId);
}
