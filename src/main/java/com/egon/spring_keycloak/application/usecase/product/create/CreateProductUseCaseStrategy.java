package com.egon.spring_keycloak.application.usecase.product.create;

import com.egon.spring_keycloak.application.shared.interfaces.UserRoleBeanStrategy;

import java.math.BigDecimal;

public interface CreateProductUseCaseStrategy extends UserRoleBeanStrategy {
  String execute(BigDecimal value);
}
