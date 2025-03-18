package com.egon.spring_keycloak.components;

import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public abstract class UseCaseStrategySelector<T extends UserRoleBeanStrategy> {
  private final UserRolesAdapter userRolesAdapter;
  private final List<T> strategies;

  abstract T getDefaultUseCase();

  public T getUseCaseStrategy() {
    System.out.println(strategies);

    return strategies.stream()
        .filter(strategy -> strategy.supports(getUser()))
        .findFirst()
        .orElse(getDefaultUseCase());
  }

  private UserDto getUser() {
    return new UserDto(userRolesAdapter.getRoles());
  }
}
