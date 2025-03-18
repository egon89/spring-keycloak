package com.egon.spring_keycloak.application.usecase.product.create.impl;

import com.egon.spring_keycloak.application.usecase.product.create.CreateProductUseCaseStrategy;
import com.egon.spring_keycloak.application.dto.user.UserDto;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class CreateProductAdminUseCaseStrategyImpl implements CreateProductUseCaseStrategy {
  @Override
  public String execute(BigDecimal value) {
    return "createProductAdminUseCaseStrategyImpl: %s".formatted(value.multiply(BigDecimal.TWO));
  }

  @Override
  public boolean supports(UserDto user) {
    return user.subRoles().contains("ROLE_ADMIN");
  }
}
