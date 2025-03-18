package com.egon.spring_keycloak.components;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FindProductUseCaseSelector extends UseCaseStrategySelector<FindProductUseCaseStrategy> {

  public FindProductUseCaseSelector(
      UserRolesAdapter userRolesAdapter,
      List<FindProductUseCaseStrategy> strategies) {
    super(userRolesAdapter, strategies);
  }

  @Override
  FindProductUseCaseStrategy getDefaultUseCase() {
    return new FindProductDefaultUseCaseStrategyImpl();
  }
}
