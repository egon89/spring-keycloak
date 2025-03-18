package com.egon.spring_keycloak.controllers;

import java.util.List;

import com.egon.spring_keycloak.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.egon.spring_keycloak.controllers.dtos.ProductResponseDto;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService service;

    @GetMapping("/strategy")
    public ResponseEntity<String> get() {
        return ResponseEntity.ok(service.execute());
    }

    @GetMapping
    @PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
    public ResponseEntity<List<ProductResponseDto>> getProducts() {
        return ResponseEntity.ok(
            List.of(ProductResponseDto.create()));
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<ProductResponseDto> createProduct() {
        return ResponseEntity.ok(ProductResponseDto.create());
    }
}
