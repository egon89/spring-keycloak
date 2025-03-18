package com.egon.spring_keycloak.components;

import org.springframework.stereotype.Component;

@Component("findProcessByProfileTwoUseCaseStrategyImpl")
public class FindProductByProfileTwoUseCaseStrategyImpl implements FindProductUseCaseStrategy {
  @Override
  public String execute() {
    return "FindProcessByProfileTwoUseCaseStrategyImpl";
  }

  @Override
  public boolean supports(UserDto user) {
    return false;
  }

  @Override
  public String getBeanName() {
    return "findProcessByProfileTwoUseCaseStrategyImpl";
  }
}
