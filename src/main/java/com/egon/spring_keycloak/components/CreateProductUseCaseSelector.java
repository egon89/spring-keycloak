package com.egon.spring_keycloak.components;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CreateProductUseCaseSelector extends UseCaseStrategySelector<CreateProductUseCaseStrategy> {

  public CreateProductUseCaseSelector(
      UserRolesAdapter userRolesAdapter,
      List<CreateProductUseCaseStrategy> strategies) {
    super(userRolesAdapter, strategies);
  }

  @Override
  CreateProductUseCaseStrategy getDefaultUseCase() {
    return new CreateProductDefaultUseCaseStrategyImpl();
  }
}
