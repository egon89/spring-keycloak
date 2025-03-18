package com.egon.spring_keycloak.application.service.product;

import com.egon.spring_keycloak.application.dto.product.CreateProductInputDto;
import com.egon.spring_keycloak.application.dto.product.FindAllProductOutputDto;

public interface ProductService {
  FindAllProductOutputDto findAll();
  void create(CreateProductInputDto input);
}
