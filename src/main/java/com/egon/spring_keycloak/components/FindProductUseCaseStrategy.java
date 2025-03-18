package com.egon.spring_keycloak.components;

import com.egon.spring_keycloak.controllers.dtos.FindProductOutputDto;

public interface FindProductUseCaseStrategy extends UserRoleBeanStrategy {
  FindProductOutputDto execute();
}
