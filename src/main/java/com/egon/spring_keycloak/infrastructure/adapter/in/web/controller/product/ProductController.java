package com.egon.spring_keycloak.infrastructure.adapter.in.web.controller.product;

import com.egon.spring_keycloak.application.dto.product.FindAllProductOutputDto;
import com.egon.spring_keycloak.application.selector.product.CreateProductUseCaseSelector;
import com.egon.spring_keycloak.application.selector.product.FindProductUseCaseSelector;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private final FindProductUseCaseSelector findProductUseCaseSelector;
    private final CreateProductUseCaseSelector createProductUseCaseSelector;

    @GetMapping()
    @PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
    public ResponseEntity<FindAllProductOutputDto> findAll() {
        return ResponseEntity.ok(findProductUseCaseSelector.getUseCaseStrategy().execute());
    }

    @PostMapping("/strategy")
    public ResponseEntity<String> createProductStrategy() {
        return ResponseEntity.ok(createProductUseCaseSelector.getUseCaseStrategy().execute(BigDecimal.TEN));
    }
}
