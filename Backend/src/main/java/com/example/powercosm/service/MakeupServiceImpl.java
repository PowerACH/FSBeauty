package com.example.powercosm.service;

import com.example.powercosm.models.Makeup;
import com.example.powercosm.repositories.MakeupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class MakeupServiceImpl implements MakeupService{

    @Autowired
    MakeupRepository MakeupRepository;

    @Override
    public Makeup createMakeup(Makeup newMakeup) {
        return MakeupRepository.save(newMakeup);
    }

    @Override
    public Iterable<Makeup> listMakeup(){
        return MakeupRepository.findAll();
    }

    @Override
    public Makeup getMakeup(String prodName) {
        return MakeupRepository.findByName(prodName);
    }

    @Override
    public HttpStatus deleteById(Long prodId) { MakeupRepository.deleteById(prodId);
        return null;
    }
}
