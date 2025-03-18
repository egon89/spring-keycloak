package com.egon.spring_keycloak.services;

import com.egon.spring_keycloak.components.CheckPermission;
import com.egon.spring_keycloak.components.FindProductUseCaseStrategy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor // no lombok usage
public class ProductService {

  private final FindProductUseCaseStrategy findProductUseCaseStrategy;

  @CheckPermission(strategy = FindProductUseCaseStrategy.class)
  public String execute() {
    return findProductUseCaseStrategy.execute();
  }
}
