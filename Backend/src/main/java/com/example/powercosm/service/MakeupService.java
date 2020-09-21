package com.example.powercosm.service;

import com.example.powercosm.models.Makeup;
import org.springframework.http.HttpStatus;

public interface MakeupService {

    public Makeup createMakeup(Makeup newMakeup);

    public Iterable<Makeup> listMakeup();

    public Makeup getMakeup(String prodName);

    public HttpStatus deleteById(Long prodId);
}
