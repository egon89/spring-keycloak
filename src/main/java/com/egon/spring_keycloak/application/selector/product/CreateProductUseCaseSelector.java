package com.egon.spring_keycloak.application.selector.product;

import com.egon.spring_keycloak.application.port.out.UserRolePort;
import com.egon.spring_keycloak.application.usecase.product.create.CreateProductUseCaseStrategy;
import com.egon.spring_keycloak.application.usecase.product.create.impl.CreateProductDefaultUseCaseStrategyImpl;
import com.egon.spring_keycloak.application.selector.BaseUseCaseStrategySelector;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CreateProductUseCaseSelector extends BaseUseCaseStrategySelector<CreateProductUseCaseStrategy> {

  public CreateProductUseCaseSelector(
      UserRolePort userRolePort,
      List<CreateProductUseCaseStrategy> strategies) {
    super(userRolePort, strategies);
  }

  @Override
  public CreateProductUseCaseStrategy getDefaultUseCase() {
    return new CreateProductDefaultUseCaseStrategyImpl();
  }
}
