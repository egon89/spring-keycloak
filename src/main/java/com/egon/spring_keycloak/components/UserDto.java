package com.egon.spring_keycloak.components;

import java.util.List;

public record UserDto(List<String> subRoles) {
}
