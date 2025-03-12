package com.egon.spring_keycloak.utils;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;

import lombok.experimental.UtilityClass;

@UtilityClass
public class RoleUtil {
    public static boolean hasRole(String role) {
        Collection<? extends GrantedAuthority> authorities =
                SecurityContextHolder.getContext().getAuthentication().getAuthorities();
        return authorities.stream().anyMatch(auth -> auth.getAuthority().equals(role));
    }

    public static boolean isAdmin() {
        return hasRole("ROLE_ADMIN");
    }
}
