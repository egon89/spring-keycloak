package com.egon.spring_keycloak.application.usecase.product.findAll;

import com.egon.spring_keycloak.application.dto.product.FindAllProductOutputDto;
import com.egon.spring_keycloak.application.shared.interfaces.UserRoleBeanStrategy;

public interface FindAllProductUseCaseStrategy extends UserRoleBeanStrategy {
  FindAllProductOutputDto execute();
}
