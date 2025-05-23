package com.zerefstbl.store.entrypoint.rest.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

public record ProductResponse(
        @JsonProperty("id")
        long id,
        @JsonProperty("name")
        String name,
        @JsonProperty("description")
        String description,
        @JsonProperty("price")
        BigDecimal price
) {
}
