package com.egon.spring_keycloak.application.usecase.product.create.impl;

import com.egon.spring_keycloak.application.dto.product.CreateProductInputDto;
import com.egon.spring_keycloak.application.dto.user.UserDto;
import com.egon.spring_keycloak.application.usecase.product.create.CreateProductUseCaseStrategy;
import org.springframework.stereotype.Component;

@Component
public class CreateProductDefaultUseCaseStrategyImpl implements CreateProductUseCaseStrategy {
  @Override
  public void execute(CreateProductInputDto input) {
    System.out.println("default cannot create a product");
  }

  @Override
  public boolean supports(UserDto user) {
    return false;
  }
}
