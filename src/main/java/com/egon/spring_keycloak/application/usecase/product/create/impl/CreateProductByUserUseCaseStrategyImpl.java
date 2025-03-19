package com.egon.spring_keycloak.application.usecase.product.create.impl;

import com.egon.spring_keycloak.application.dto.product.CreateProductInputDto;
import com.egon.spring_keycloak.application.dto.user.UserDto;
import com.egon.spring_keycloak.application.port.out.SaveProductPort;
import com.egon.spring_keycloak.application.usecase.product.create.CreateProductUseCaseStrategy;
import com.egon.spring_keycloak.domain.entity.Product;
import com.egon.spring_keycloak.domain.exception.InvalidPriceLimit;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Objects;

@Component
@RequiredArgsConstructor
public class CreateProductByUserUseCaseStrategyImpl implements CreateProductUseCaseStrategy {
  private static final BigDecimal PRICE_LIMIT = new BigDecimal(500);

  private final SaveProductPort saveProductPort;

  @Override
  public void execute(CreateProductInputDto input) {
    if (isGreaterThanPriceLimit(input.getPrice())) {
      throw new InvalidPriceLimit();
    }

    this.saveProductPort.save(this.toEntity(input));
  }

  @Override
  public boolean supports(UserDto user) {
    return user.subRoles().contains("ROLE_USER");
  }

  private static boolean isGreaterThanPriceLimit(BigDecimal value) {
    return Objects.nonNull(value) && value.compareTo(PRICE_LIMIT) > 0;
  }

  private Product toEntity(CreateProductInputDto input) {
    return new Product(null, input.getName(), input.getPrice(), Boolean.FALSE);
  }
}
