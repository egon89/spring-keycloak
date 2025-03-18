package com.egon.spring_keycloak.components;

import org.springframework.stereotype.Component;

@Component
public class FindProductByProfileTwoUseCaseStrategyImpl implements FindProductUseCaseStrategy {
  @Override
  public String execute() {
    return "findProductByProfileTwoUseCaseStrategyImpl";
  }

  @Override
  public boolean supports(UserDto user) {
    return "p2".equalsIgnoreCase(user.profile());
  }

  @Override
  public String getBeanName() {
    return "findProductByProfileTwoUseCaseStrategyImpl";
  }
}
