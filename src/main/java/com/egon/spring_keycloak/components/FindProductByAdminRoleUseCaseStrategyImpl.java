package com.egon.spring_keycloak.components;

import org.springframework.stereotype.Component;

@Component
public class FindProductByAdminRoleUseCaseStrategyImpl implements FindProductUseCaseStrategy {
  @Override
  public String execute() {
    return "findProductByAdminRoleUseCaseStrategyImpl";
  }

  @Override
  public boolean supports(UserDto user) {
    return user.subRoles().contains("ROLE_ADMIN");
  }
}
