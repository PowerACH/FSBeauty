package com.example.powercosm.service;

import com.example.powercosm.models.Skincare;
import com.example.powercosm.repositories.SkincareRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class SkincareServiceImpl implements SkincareService{

    @Autowired
    SkincareRepository skincareRepository;

    @Override
    public Skincare createSkincare(Skincare newSkincare) {
        return skincareRepository.save(newSkincare);
    }

    @Override
    public Iterable<Skincare> listSkincare(){
        return skincareRepository.findAll();
    }

    @Override
    public Skincare getSkincare(String prodName) {
        return skincareRepository.findByName(prodName);
    }

    @Override
    public HttpStatus deleteById(Long prodId) { skincareRepository.deleteById(prodId);
        return null;
    }
}
