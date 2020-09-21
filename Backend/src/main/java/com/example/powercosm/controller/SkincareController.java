package com.example.powercosm.controller;

import com.example.powercosm.models.Skincare;
import com.example.powercosm.service.SkincareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/skincare")
public class SkincareController {

    @Autowired
    SkincareService skincareService;

    @GetMapping
    public Iterable<Skincare> listSkincare() {
        return skincareService.listSkincare();
    }

    @PostMapping
    public Skincare createSkincare(@RequestBody Skincare newSkincare) {
        return skincareService.createSkincare(newSkincare);
    }

    @GetMapping("/{prodName}")
    public Skincare getSkincare(@PathVariable String prodName) {
        return skincareService.getSkincare(prodName);
    }

    @DeleteMapping("/{prodId}")
    public HttpStatus deleteById(@PathVariable Long prodId) { return skincareService.deleteById(prodId);}
}
