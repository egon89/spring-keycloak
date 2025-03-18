package com.egon.spring_keycloak.services;

import com.egon.spring_keycloak.components.CreateProductUseCaseSelector;
import com.egon.spring_keycloak.components.FindProductUseCaseSelector;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class ProductService {

  private final FindProductUseCaseSelector findProductUseCaseSelector;
  private final CreateProductUseCaseSelector createProductUseCaseSelector;

  public String find() {
    final var useCase = findProductUseCaseSelector.getUseCaseStrategy();

    return useCase.execute();
  }

  public String create(BigDecimal value) {
    final var useCase = createProductUseCaseSelector.getUseCaseStrategy();

    return useCase.execute(value);
  }
}
