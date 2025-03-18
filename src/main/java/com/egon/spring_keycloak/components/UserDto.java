package com.egon.spring_keycloak.components;

import java.util.List;

public record UserDto(String profile, List<String> subRoles) {
}
