package com.zerefstbl.store.application.outputs;

import com.zerefstbl.store.domain.model.Product;

import java.math.BigDecimal;

public record CreateProductOutput(long id, String name, String description, BigDecimal price) {
    
    public static CreateProductOutput from(final Product product) {
        return new CreateProductOutput(product.getId(), product.getName(), product.getDescription(), product.getPrice());
    }

}
