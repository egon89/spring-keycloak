package com.egon.spring_keycloak.infrastructure.adapter.in.web.controller.product;

import com.egon.spring_keycloak.application.dto.product.CreateProductInputDto;
import com.egon.spring_keycloak.application.dto.product.FindAllProductOutputDto;
import com.egon.spring_keycloak.application.selector.product.CreateProductUseCaseSelector;
import com.egon.spring_keycloak.application.selector.product.FindProductUseCaseSelector;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping()
//    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> createProductStrategy(@RequestBody CreateProductInputDto input) {
        createProductUseCaseSelector.getUseCaseStrategy().execute(input);

        return ResponseEntity.noContent().build();
    }
}
