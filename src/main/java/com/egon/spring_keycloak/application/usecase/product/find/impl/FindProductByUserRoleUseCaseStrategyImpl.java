package com.egon.spring_keycloak.application.usecase.product.find.impl;

import com.egon.spring_keycloak.application.usecase.product.find.FindProductUseCaseStrategy;
import com.egon.spring_keycloak.application.dto.user.UserDto;
import com.egon.spring_keycloak.application.dto.product.FindProductOutputDto;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class FindProductByUserRoleUseCaseStrategyImpl implements FindProductUseCaseStrategy {
  @Override
  public FindProductOutputDto execute() {
    return new FindProductOutputDto("uuid2", "Product User", BigDecimal.valueOf(5.99));
  }

  @Override
  public boolean supports(UserDto user) {
    return user.subRoles().contains("ROLE_USER");
  }
}
