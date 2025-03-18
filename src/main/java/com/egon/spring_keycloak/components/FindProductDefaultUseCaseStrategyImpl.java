package com.egon.spring_keycloak.components;

import com.egon.spring_keycloak.controllers.dtos.FindProductOutputDto;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class FindProductDefaultUseCaseStrategyImpl implements FindProductUseCaseStrategy {
  @Override
  public FindProductOutputDto execute() {
    return new FindProductOutputDto("uuid1", "Product Default", BigDecimal.TWO);
  }

  @Override
  public boolean supports(UserDto user) {
    return false;
  }
}


