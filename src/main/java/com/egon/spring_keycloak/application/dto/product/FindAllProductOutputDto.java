package com.egon.spring_keycloak.application.dto.product;

import java.util.List;

public record FindAllProductOutputDto(List<ProductOutputDto> products) {
  public static FindAllProductOutputDto of(List<ProductOutputDto> products) {
    return new FindAllProductOutputDto(products);
  }
}
