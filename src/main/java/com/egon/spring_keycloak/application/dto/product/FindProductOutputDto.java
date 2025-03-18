package com.egon.spring_keycloak.application.dto.product;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class FindProductOutputDto {
  String id;
  String name;
  BigDecimal price;

  public static FindProductOutputDto create() {
    return new FindProductOutputDto("1", "Product 1", BigDecimal.valueOf(19.97));
  }
}
