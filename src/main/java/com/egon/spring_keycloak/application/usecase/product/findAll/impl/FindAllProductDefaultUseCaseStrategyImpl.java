package com.egon.spring_keycloak.application.usecase.product.findAll.impl;

import com.egon.spring_keycloak.application.dto.product.FindAllProductOutputDto;
import com.egon.spring_keycloak.application.dto.user.UserDto;
import com.egon.spring_keycloak.application.usecase.product.findAll.FindAllProductUseCaseStrategy;
import org.springframework.stereotype.Component;

import java.util.Collections;

@Component
public class FindAllProductDefaultUseCaseStrategyImpl implements FindAllProductUseCaseStrategy {

  @Override
  public FindAllProductOutputDto execute() {
    return FindAllProductOutputDto.of(Collections.emptyList());
  }

  @Override
  public boolean supports(UserDto user) {
    return false;
  }
}


