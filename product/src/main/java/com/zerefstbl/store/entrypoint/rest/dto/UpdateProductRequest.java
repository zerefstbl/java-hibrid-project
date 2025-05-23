package com.zerefstbl.store.entrypoint.rest.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;

public record UpdateProductRequest(
        @JsonProperty("name")
        @Size(min = 5, max = 50)
        @NotBlank
        String name,
        @JsonProperty("description")
        @Size(max = 255)
        String description,
        @JsonProperty("price")
        @NotNull
        BigDecimal price
) {
}
