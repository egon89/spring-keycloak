package com.egon.spring_keycloak.infrastructure.adapter.in.web.controller.product;

import com.egon.spring_keycloak.application.dto.product.FindProductOutputDto;
import com.egon.spring_keycloak.application.selector.product.CreateProductUseCaseSelector;
import com.egon.spring_keycloak.application.selector.product.FindProductUseCaseSelector;
import com.egon.spring_keycloak.infrastructure.adapter.in.web.controller.product.dto.ProductResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private final FindProductUseCaseSelector findProductUseCaseSelector;
    private final CreateProductUseCaseSelector createProductUseCaseSelector;

    @GetMapping("/strategy")
//    @PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
    public ResponseEntity<List<FindProductOutputDto>> findAll() {
        return ResponseEntity.ok(findProductUseCaseSelector.getUseCaseStrategy().execute());
    }

    @PostMapping("/strategy")
    public ResponseEntity<String> createProductStrategy() {
        return ResponseEntity.ok(createProductUseCaseSelector.getUseCaseStrategy().execute(BigDecimal.TEN));
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
