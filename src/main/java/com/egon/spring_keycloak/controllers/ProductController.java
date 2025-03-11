package com.egon.spring_keycloak.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductController {
    
    @GetMapping
    @PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
    public String getProducts() {
        return "Products";
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public String createProduct() {
        return "Product Created";
    }
}
