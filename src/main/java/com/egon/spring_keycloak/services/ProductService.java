package com.egon.spring_keycloak.services;

import com.egon.spring_keycloak.components.CheckPermission;
import com.egon.spring_keycloak.components.FindProductUseCaseStrategy;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
//@RequiredArgsConstructor // no lombok usage
public class ProductService {

//  @Autowired
//  @Qualifier("findProcessDefaultStrategy")
//  private FindProductUseCaseStrategy findProductUseCaseStrategy;

  private final FindProductUseCaseStrategy findProductUseCaseStrategy;

  public ProductService(@Qualifier("findProcessDefaultStrategy") FindProductUseCaseStrategy findProductUseCaseStrategy) {
    this.findProductUseCaseStrategy = findProductUseCaseStrategy;
  }

  @CheckPermission(profile = "p1", subrole = "sr1", strategy = FindProductUseCaseStrategy.class)
  public String execute() {
    return findProductUseCaseStrategy.execute();
  }
}
