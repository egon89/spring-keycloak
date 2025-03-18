package com.egon.spring_keycloak.components;

import org.springframework.stereotype.Component;

@Component
public class FindProductByUserRoleUseCaseStrategyImpl implements FindProductUseCaseStrategy {
  @Override
  public String execute() {
    return "findProductByUserRoleUseCaseStrategyImpl";
  }

  @Override
  public boolean supports(UserDto user) {
    return user.subRoles().contains("ROLE_USER");
  }

  @Override
  public String getBeanName() {
    return "findProductByUserRoleUseCaseStrategyImpl";
  }
}
