package com.egon.spring_keycloak.infrastructure.adapter.out;

import com.egon.spring_keycloak.application.port.out.FindAllProductPort;
import com.egon.spring_keycloak.domain.entity.Product;
import com.egon.spring_keycloak.infrastructure.jpa.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ProductRepositoryAdapter implements FindAllProductPort {
  private final ProductRepository repository;


  @Override
  public List<Product> findAll() {
    return repository.findAll();
  }
}
