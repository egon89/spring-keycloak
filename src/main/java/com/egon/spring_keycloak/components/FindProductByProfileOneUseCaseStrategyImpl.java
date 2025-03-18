package com.egon.spring_keycloak.components;

import org.springframework.stereotype.Component;

@Component("findProcessByProfileOneUseCaseStrategyImpl")
public class FindProductByProfileOneUseCaseStrategyImpl implements FindProductUseCaseStrategy {
  @Override
  public String execute() {
    return "FindProcessByProfileOneUseCaseStrategyImpl";
  }

  @Override
  public boolean supports(UserDto user) {
    return false;
  }

  @Override
  public String getBeanName() {
    return "findProcessByProfileOneUseCaseStrategyImpl";
  }
}
