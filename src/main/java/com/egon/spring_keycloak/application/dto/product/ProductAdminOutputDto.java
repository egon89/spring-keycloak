package com.egon.spring_keycloak.application.dto.product;

import lombok.Getter;

import java.math.BigDecimal;

@Getter
public class ProductAdminOutputDto extends ProductOutputDto {
  private final boolean available;

  public ProductAdminOutputDto(String id, String name, BigDecimal price, boolean available) {
    super(id, name, price);
    this.available = available;
  }

  public static ProductAdminOutputDto create() {
    return new ProductAdminOutputDto("1", "Product 1", BigDecimal.valueOf(19.97), true);
  }
}
