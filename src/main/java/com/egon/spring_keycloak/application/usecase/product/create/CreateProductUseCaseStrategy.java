package com.egon.spring_keycloak.application.usecase.product.create;

import com.egon.spring_keycloak.application.dto.product.CreateProductInputDto;
import com.egon.spring_keycloak.application.shared.interfaces.UserRoleBeanStrategy;

public interface CreateProductUseCaseStrategy extends UserRoleBeanStrategy {
  void execute(CreateProductInputDto input);
}
