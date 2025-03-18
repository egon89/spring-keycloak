package com.egon.spring_keycloak.application.port.out;

import com.egon.spring_keycloak.domain.entity.Product;

import java.util.List;

public interface FindAllProductPort {
  List<Product> findAll();
}
