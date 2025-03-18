package com.egon.spring_keycloak.components;

public interface FindProductUseCaseStrategy {
  String execute();
  boolean supports(UserDto user);
  String getBeanName();
}
