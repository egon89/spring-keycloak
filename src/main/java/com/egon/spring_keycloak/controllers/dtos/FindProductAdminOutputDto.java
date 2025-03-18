package com.egon.spring_keycloak.controllers.dtos;

import lombok.Getter;

import java.math.BigDecimal;

@Getter
public class FindProductAdminOutputDto extends FindProductOutputDto {
  private final boolean available;

  public FindProductAdminOutputDto(String id, String name, BigDecimal price, boolean available) {
    super(id, name, price);
    this.available = available;
  }

  public static FindProductAdminOutputDto create() {
    return new FindProductAdminOutputDto("1", "Product 1", BigDecimal.valueOf(19.97), true);
  }
}
