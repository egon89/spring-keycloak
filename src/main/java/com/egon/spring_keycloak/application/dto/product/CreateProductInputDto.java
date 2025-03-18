package com.egon.spring_keycloak.application.dto.product;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class CreateProductInputDto {

  private String name;

  private BigDecimal price;
}
