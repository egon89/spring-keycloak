package com.egon.spring_keycloak.application.shared.interfaces;

import com.egon.spring_keycloak.application.dto.user.UserDto;

public interface UserRoleBeanStrategy {
  boolean supports(UserDto user);
}
