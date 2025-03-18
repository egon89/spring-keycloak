package com.egon.spring_keycloak.components;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Primary
@Component
public class FindProductDefaultStrategy implements FindProductUseCaseStrategy {
  @Override
  public String execute() {
    return "findProductDefaultStrategy";
  }

  @Override
  public boolean supports(UserDto user) {
    return true;
  }

  @Override
  public String getBeanName() {
    return "findProductDefaultStrategy";
  }
}


