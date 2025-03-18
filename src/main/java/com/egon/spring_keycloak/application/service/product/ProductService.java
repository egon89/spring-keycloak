package com.egon.spring_keycloak.application.service.product;

import com.egon.spring_keycloak.application.dto.product.FindAllProductOutputDto;

import java.math.BigDecimal;

public interface ProductService {
  FindAllProductOutputDto findAll();
  String create(BigDecimal value);
}
