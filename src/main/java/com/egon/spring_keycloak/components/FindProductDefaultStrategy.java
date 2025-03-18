package com.egon.spring_keycloak.components;

import org.springframework.stereotype.Component;

@Component("findProcessDefaultStrategy")
public class FindProductDefaultStrategy implements FindProductUseCaseStrategy {
  @Override
  public String execute() {
    return "FindProcessDefaultStrategy";
  }

  @Override
  public boolean supports(UserDto user) {
    return true;
  }

  @Override
  public String getBeanName() {
    return "findProcessDefaultStrategy";
  }
}


