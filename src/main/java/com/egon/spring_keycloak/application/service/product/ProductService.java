package com.egon.spring_keycloak.application.service.product;

import com.egon.spring_keycloak.application.dto.product.FindProductOutputDto;

import java.math.BigDecimal;

public interface ProductService {
  FindProductOutputDto find();
  String create(BigDecimal value);
}
