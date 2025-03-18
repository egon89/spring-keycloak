package com.egon.spring_keycloak.application.usecase.product.find.impl;

import com.egon.spring_keycloak.application.usecase.product.find.FindProductUseCaseStrategy;
import com.egon.spring_keycloak.application.dto.user.UserDto;
import com.egon.spring_keycloak.application.dto.product.FindProductAdminOutputDto;
import com.egon.spring_keycloak.application.dto.product.FindProductOutputDto;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class FindProductByAdminRoleUseCaseStrategyImpl implements FindProductUseCaseStrategy {
  @Override
  public FindProductOutputDto execute() {
    return new FindProductAdminOutputDto("uuid3", "Product Admin", BigDecimal.valueOf(15.98), true);
  }

  @Override
  public boolean supports(UserDto user) {
    return user.subRoles().contains("ROLE_ADMIN");
  }
}
