package com.egon.spring_keycloak.application.service.product.impl;

import com.egon.spring_keycloak.application.dto.product.FindAllProductOutputDto;
import com.egon.spring_keycloak.application.selector.product.CreateProductUseCaseSelector;
import com.egon.spring_keycloak.application.selector.product.FindProductUseCaseSelector;
import com.egon.spring_keycloak.application.service.product.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

  private final FindProductUseCaseSelector findProductUseCaseSelector;
  private final CreateProductUseCaseSelector createProductUseCaseSelector;

  public FindAllProductOutputDto findAll() {
    final var useCase = findProductUseCaseSelector.getUseCaseStrategy();

    return useCase.execute();
  }

  public String create(BigDecimal value) {
    final var useCase = createProductUseCaseSelector.getUseCaseStrategy();

    return useCase.execute(value);
  }
}
