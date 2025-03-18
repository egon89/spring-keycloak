package com.egon.spring_keycloak.application.dto.product;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class ProductOutputDto {
  String id;
  String name;
  BigDecimal price;

  public static ProductOutputDto create() {
    return new ProductOutputDto("1", "Product 1", BigDecimal.valueOf(19.97));
  }
}
