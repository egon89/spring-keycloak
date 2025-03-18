package com.egon.spring_keycloak.components;

import org.springframework.stereotype.Component;

@Component
public class FindProductDefaultUseCaseStrategyImpl implements FindProductUseCaseStrategy {
  @Override
  public String execute() {
    return "findProductDefaultUseCaseStrategyImpl";
  }

  @Override
  public boolean supports(UserDto user) {
    return false;
  }
}


