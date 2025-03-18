package com.egon.spring_keycloak.application.port.out;

import com.egon.spring_keycloak.domain.entity.Product;

public interface SaveProductPort {
  void save(Product product);
}
