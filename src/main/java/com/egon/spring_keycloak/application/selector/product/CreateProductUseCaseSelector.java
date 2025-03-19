package com.egon.spring_keycloak.application.selector.product;

import com.egon.spring_keycloak.application.port.out.UserRolePort;
import com.egon.spring_keycloak.application.selector.BaseUseCaseStrategySelector;
import com.egon.spring_keycloak.application.usecase.product.create.CreateProductUseCaseStrategy;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CreateProductUseCaseSelector extends BaseUseCaseStrategySelector<CreateProductUseCaseStrategy> {

  public CreateProductUseCaseSelector(
      UserRolePort userRolePort,
      List<CreateProductUseCaseStrategy> strategies) {
    super(userRolePort, strategies);
  }
}
