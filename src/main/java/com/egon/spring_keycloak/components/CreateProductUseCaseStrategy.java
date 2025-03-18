package com.egon.spring_keycloak.components;

import java.math.BigDecimal;

public interface CreateProductUseCaseStrategy extends UserRoleBeanStrategy {
  String execute(BigDecimal value);
}
