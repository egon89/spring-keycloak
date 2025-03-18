package com.egon.spring_keycloak.application.usecase.product.find.impl;

import com.egon.spring_keycloak.application.dto.product.FindProductOutputDto;
import com.egon.spring_keycloak.application.dto.user.UserDto;
import com.egon.spring_keycloak.application.usecase.product.find.FindProductUseCaseStrategy;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

@Component
public class FindProductDefaultUseCaseStrategyImpl implements FindProductUseCaseStrategy {

  @Override
  public List<FindProductOutputDto> execute() {
    return Collections.emptyList();
  }

  @Override
  public boolean supports(UserDto user) {
    return false;
  }
}


