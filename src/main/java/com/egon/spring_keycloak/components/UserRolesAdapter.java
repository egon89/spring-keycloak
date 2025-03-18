package com.egon.spring_keycloak.components;

import com.egon.spring_keycloak.configurations.security.JwtConverter;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Component
public class UserRolesAdapter {
  public List<String> getRoles() {
    final var credentials =  SecurityContextHolder.getContext().getAuthentication().getCredentials();
    try {
      final var authenticationToken = new JwtConverter().convert((Jwt) credentials);
      final var authorities = Optional.ofNullable(authenticationToken)
          .map(AbstractAuthenticationToken::getAuthorities)
          .orElse(Collections.emptyList());

      return authorities.stream().map(Object::toString).toList();
    } catch (Exception e) {
      return Collections.emptyList();
    }
  }
}
