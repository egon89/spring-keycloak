package com.egon.spring_keycloak.application.selector;

import com.egon.spring_keycloak.application.dto.user.UserDto;
import com.egon.spring_keycloak.application.port.out.UserRolePort;
import com.egon.spring_keycloak.application.shared.interfaces.UserRoleBeanStrategy;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public abstract class BaseUseCaseStrategySelector<T extends UserRoleBeanStrategy> {
  private final UserRolePort userRolePort;
  private final List<T> strategies;

  public T getUseCaseStrategy() {
    return strategies.stream()
        .filter(strategy -> strategy.supports(getUser()))
        .findFirst()
        .orElseThrow(() -> new IllegalArgumentException("No strategy found"));
  }

  private UserDto getUser() {
    return new UserDto(userRolePort.getRoles());
  }
}
