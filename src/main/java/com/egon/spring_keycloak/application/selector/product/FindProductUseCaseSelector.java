package com.egon.spring_keycloak.application.selector.product;

import com.egon.spring_keycloak.application.port.out.UserRolePort;
import com.egon.spring_keycloak.application.usecase.product.findAll.FindAllProductUseCaseStrategy;
import com.egon.spring_keycloak.application.usecase.product.findAll.impl.FindAllProductDefaultUseCaseStrategyImpl;
import com.egon.spring_keycloak.application.selector.BaseDefaultUseCaseStrategySelector;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FindProductUseCaseSelector extends BaseDefaultUseCaseStrategySelector<FindAllProductUseCaseStrategy> {

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
