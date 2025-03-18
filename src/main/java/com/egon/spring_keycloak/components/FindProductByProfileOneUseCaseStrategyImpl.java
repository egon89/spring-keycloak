package com.egon.spring_keycloak.components;

import org.springframework.stereotype.Component;

@Component
public class FindProductByProfileOneUseCaseStrategyImpl implements FindProductUseCaseStrategy {
  @Override
  public String execute() {
    return "findProductByProfileOneUseCaseStrategyImpl";
  }

  @Override
  public boolean supports(UserDto user) {
    return "p1".equalsIgnoreCase(user.profile());
  }

  @Override
  public String getBeanName() {
    return "findProductByProfileOneUseCaseStrategyImpl";
  }
}
