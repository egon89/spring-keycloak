package com.egon.spring_keycloak.application.dto.user;

import java.util.List;

public record UserDto(List<String> subRoles) {
}
