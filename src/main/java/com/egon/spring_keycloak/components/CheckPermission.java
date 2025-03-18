package com.egon.spring_keycloak.components;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface CheckPermission {
  String profile();
  String subrole();
  Class<? extends FindProductUseCaseStrategy> strategy();
}
