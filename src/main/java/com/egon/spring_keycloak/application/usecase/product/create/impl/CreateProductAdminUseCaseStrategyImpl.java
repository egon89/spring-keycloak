package com.egon.spring_keycloak.application.usecase.product.create.impl;

import com.egon.spring_keycloak.application.dto.product.CreateProductInputDto;
import com.egon.spring_keycloak.application.dto.user.UserDto;
import com.egon.spring_keycloak.application.port.out.SaveProductPort;
import com.egon.spring_keycloak.application.usecase.product.create.CreateProductUseCaseStrategy;
import com.egon.spring_keycloak.domain.entity.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CreateProductAdminUseCaseStrategyImpl implements CreateProductUseCaseStrategy {

  private final SaveProductPort saveProductPort;

  @Override
  public void execute(CreateProductInputDto input) {
    this.saveProductPort.save(this.toEntity(input));
  }

  @Override
  public boolean supports(UserDto user) {
    return user.subRoles().contains("ROLE_ADMIN");
  }

  private Product toEntity(CreateProductInputDto input) {
    return new Product(null, input.getName(), input.getPrice(), Boolean.FALSE);
  }
}
