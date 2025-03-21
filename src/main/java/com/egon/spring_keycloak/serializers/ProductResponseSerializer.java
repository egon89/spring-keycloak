package com.egon.spring_keycloak.serializers;

import java.io.IOException;

import com.egon.spring_keycloak.controllers.dtos.ProductResponseDto;
import com.egon.spring_keycloak.utils.RoleUtil;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

public class ProductResponseSerializer extends JsonSerializer<ProductResponseDto> {
    @Override
    public void serialize(ProductResponseDto value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        gen.writeStartObject();
        gen.writeStringField("id", value.getId());
        gen.writeStringField("name", value.getName());
        gen.writeNumberField("price", value.getPrice());
        if (RoleUtil.isAdmin()) {
            gen.writeBooleanField("available", value.isAvailable());
        }
        gen.writeEndObject();
    }
}
