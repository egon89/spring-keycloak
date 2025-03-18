package com.egon.spring_keycloak.application.selector.product;

import com.egon.spring_keycloak.application.port.out.UserRolePort;
import com.egon.spring_keycloak.application.usecase.product.find.FindProductUseCaseStrategy;
import com.egon.spring_keycloak.application.usecase.product.find.impl.FindProductDefaultUseCaseStrategyImpl;
import com.egon.spring_keycloak.application.selector.BaseUseCaseStrategySelector;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FindProductUseCaseSelector extends BaseUseCaseStrategySelector<FindProductUseCaseStrategy> {

  public FindProductUseCaseSelector(
      UserRolePort userRolePort,
      List<FindProductUseCaseStrategy> strategies) {
    super(userRolePort, strategies);
  }

  @Override
  public FindProductUseCaseStrategy getDefaultUseCase() {
    return new FindProductDefaultUseCaseStrategyImpl();
  }
}
