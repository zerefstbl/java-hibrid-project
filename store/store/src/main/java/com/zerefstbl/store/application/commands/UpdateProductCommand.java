package com.zerefstbl.store.application.commands;

import java.math.BigDecimal;

public record UpdateProductCommand(long id, String name, String description, BigDecimal price) {

    public UpdateProductCommand with(final long id, final String description, final String name, final BigDecimal price) {
        return new UpdateProductCommand(id, name, description, price);
    }

}
