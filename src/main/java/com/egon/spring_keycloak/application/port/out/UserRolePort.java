package com.egon.spring_keycloak.application.port.out;

import java.util.List;

public interface UserRolePort {
  List<String> getRoles();
}
