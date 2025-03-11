package com.egon.spring_keycloak.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductController {
    
    @GetMapping
    public String getProducts() {
        return "Products";
    }

    @PostMapping
    public String createProduct() {
        return "Product Created";
    }
}
