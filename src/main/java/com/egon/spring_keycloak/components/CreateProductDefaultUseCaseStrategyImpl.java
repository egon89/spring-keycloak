package com.egon.spring_keycloak.components;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Primary
@Component
public class CreateProductDefaultUseCaseStrategyImpl implements CreateProductUseCaseStrategy {
  @Override
  public String execute(BigDecimal value) {
    return "createProductDefaultUseCaseStrategyImpl: %s".formatted(value);
  }

  @Override
  public boolean supports(UserDto user) {
    return true;
  }

  @Override
  public String getBeanName() {
    return "createProductDefaultUseCaseStrategyImpl";
  }
}
