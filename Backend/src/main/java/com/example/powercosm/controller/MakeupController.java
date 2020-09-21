package com.example.powercosm.controller;

import com.example.powercosm.models.Makeup;
import com.example.powercosm.service.MakeupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/makeup")
public class MakeupController {

    @Autowired
    private MakeupService makeupService;

    @GetMapping
    public Iterable<Makeup> listMakeup() {
        return makeupService.listMakeup();
    }

    @PostMapping
    public Makeup createMakeup(@RequestBody Makeup newMakeup) {
        return makeupService.createMakeup(newMakeup);
    }

    @GetMapping("/{prodName}")
    public Makeup getMakeup(@PathVariable String prodName) {
        return makeupService.getMakeup(prodName);
    }

    @DeleteMapping("/{prodId}")
    public HttpStatus deleteById(@PathVariable Long prodId) { return makeupService.deleteById(prodId);}
}
