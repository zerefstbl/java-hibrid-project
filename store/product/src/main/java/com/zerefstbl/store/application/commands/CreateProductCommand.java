package com.zerefstbl.store.application.commands;

import java.math.BigDecimal;

public record CreateProductCommand(String name, String description, BigDecimal price) {

    public CreateProductCommand with(final String name, final String description, final BigDecimal price) {
        return new CreateProductCommand(name, description, price);
    }

}
