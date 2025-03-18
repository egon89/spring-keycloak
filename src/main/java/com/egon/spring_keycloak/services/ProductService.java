package com.egon.spring_keycloak.services;

import com.egon.spring_keycloak.components.CheckPermission;
import com.egon.spring_keycloak.components.CreateProductUseCaseStrategy;
import com.egon.spring_keycloak.components.FindProductUseCaseStrategy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class ProductService {

  private final FindProductUseCaseStrategy findProductUseCaseStrategy;
  private final CreateProductUseCaseStrategy createProductUseCaseStrategy;

  @CheckPermission(strategy = FindProductUseCaseStrategy.class)
  public String find() {
    return findProductUseCaseStrategy.execute();
  }

  @CheckPermission(strategy = CreateProductUseCaseStrategy.class)
  public String create(BigDecimal value) {
    return createProductUseCaseStrategy.execute(value);
  }
}
