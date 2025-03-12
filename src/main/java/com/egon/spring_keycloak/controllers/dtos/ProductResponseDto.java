package com.egon.spring_keycloak.controllers.dtos;

import java.math.BigDecimal;

import com.egon.spring_keycloak.serializers.ProductResponseSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import lombok.Value;

@Value
@JsonSerialize(using = ProductResponseSerializer.class)
public class ProductResponseDto {
    String id;
    String name;
    BigDecimal price;
    boolean available;

    public static ProductResponseDto create() {
        return new ProductResponseDto("1", "Product 1", BigDecimal.valueOf(19.97), true);
    }
}
