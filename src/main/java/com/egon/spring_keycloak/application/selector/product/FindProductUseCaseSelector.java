package com.egon.spring_keycloak.application.selector.product;

import com.egon.spring_keycloak.application.port.out.UserRolePort;
import com.egon.spring_keycloak.application.usecase.product.find.FindAllProductUseCaseStrategy;
import com.egon.spring_keycloak.application.usecase.product.find.impl.FindAllProductDefaultUseCaseStrategyImpl;
import com.egon.spring_keycloak.application.selector.BaseUseCaseStrategySelector;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FindProductUseCaseSelector extends BaseUseCaseStrategySelector<FindAllProductUseCaseStrategy> {

  public FindProductUseCaseSelector(
      UserRolePort userRolePort,
      List<FindAllProductUseCaseStrategy> strategies) {
    super(userRolePort, strategies);
  }

  @Override
  public FindAllProductUseCaseStrategy getDefaultUseCase() {
    return new FindAllProductDefaultUseCaseStrategyImpl();
  }
}
