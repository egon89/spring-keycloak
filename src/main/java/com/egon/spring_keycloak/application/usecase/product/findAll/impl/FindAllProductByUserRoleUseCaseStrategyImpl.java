package com.egon.spring_keycloak.application.usecase.product.findAll.impl;

import com.egon.spring_keycloak.application.dto.product.FindAllProductOutputDto;
import com.egon.spring_keycloak.application.dto.product.ProductOutputDto;
import com.egon.spring_keycloak.application.dto.user.UserDto;
import com.egon.spring_keycloak.application.port.out.FindAllProductPort;
import com.egon.spring_keycloak.application.usecase.product.findAll.FindAllProductUseCaseStrategy;
import com.egon.spring_keycloak.domain.entity.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class FindAllProductByUserRoleUseCaseStrategyImpl implements FindAllProductUseCaseStrategy {

  private final FindAllProductPort findAllProductPort;

  @Override
  public FindAllProductOutputDto execute() {
    final var products = findAllProductPort.findAll()
        .stream().map(this::toDto).toList();

    return FindAllProductOutputDto.of(products);
  }

  @Override
  public boolean supports(UserDto user) {
    return user.subRoles().contains("ROLE_USER");
  }

  private ProductOutputDto toDto(Product product) {
    return new ProductOutputDto(product.getId(), product.getName(), product.getPrice());
  }
}
