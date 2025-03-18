package com.egon.spring_keycloak.application.service.product;

import com.egon.spring_keycloak.application.dto.product.FindProductOutputDto;

import java.math.BigDecimal;
import java.util.List;

public interface ProductService {
  List<FindProductOutputDto> find();
  String create(BigDecimal value);
}
