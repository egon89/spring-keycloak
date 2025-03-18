package com.egon.spring_keycloak.application.usecase.product.find;

import com.egon.spring_keycloak.application.shared.interfaces.UserRoleBeanStrategy;
import com.egon.spring_keycloak.application.dto.product.FindProductOutputDto;

public interface FindProductUseCaseStrategy extends UserRoleBeanStrategy {
  FindProductOutputDto execute();
}
