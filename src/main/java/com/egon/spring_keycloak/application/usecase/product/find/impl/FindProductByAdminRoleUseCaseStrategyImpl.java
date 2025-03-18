package com.egon.spring_keycloak.application.usecase.product.find.impl;

import com.egon.spring_keycloak.application.port.out.FindAllProductPort;
import com.egon.spring_keycloak.application.usecase.product.find.FindProductUseCaseStrategy;
import com.egon.spring_keycloak.application.dto.user.UserDto;
import com.egon.spring_keycloak.application.dto.product.FindProductAdminOutputDto;
import com.egon.spring_keycloak.application.dto.product.FindProductOutputDto;
import com.egon.spring_keycloak.domain.entity.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

@Component
@RequiredArgsConstructor
public class FindProductByAdminRoleUseCaseStrategyImpl implements FindProductUseCaseStrategy {

  private final FindAllProductPort findAllProductPort;

  @Override
  public List<FindProductOutputDto> execute() {
    return findAllProductPort.findAll()
        .stream().map(this::toDto).toList();
  }

  @Override
  public boolean supports(UserDto user) {
    return user.subRoles().contains("ROLE_ADMIN");
  }

  private FindProductOutputDto toDto(Product product) {
    return new FindProductAdminOutputDto(product.getId(), product.getName(), product.getPrice(), product.getAvailable());
  }
}
