package com.egon.spring_keycloak.infrastructure.configuration.security;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.NonNull;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;

public class JwtConverter implements Converter<Jwt, AbstractAuthenticationToken> {
    @Override
    public AbstractAuthenticationToken convert(@NonNull Jwt jwt) {
        Objects.requireNonNull(jwt, "jwt cannot be null");
        Map<String, Collection<String>> realmAccess = jwt.getClaim("realm_access");
        Collection<String> roles = realmAccess.get("roles");
        List<SimpleGrantedAuthority> grants = roles.stream().map(role -> new SimpleGrantedAuthority("ROLE_" + role)).toList();
        
        return new JwtAuthenticationToken(jwt, grants);
    }
    
}
