package com.egon.spring_keycloak.components;

public interface UserRoleBeanStrategy {
  boolean supports(UserDto user);
}
