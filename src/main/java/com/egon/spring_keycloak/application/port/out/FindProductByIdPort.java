package com.egon.spring_keycloak.application.port.out;

import com.egon.spring_keycloak.domain.entity.Product;

import java.util.Optional;

public interface FindProductByIdPort {
  Optional<Product> findById(String id);
}
