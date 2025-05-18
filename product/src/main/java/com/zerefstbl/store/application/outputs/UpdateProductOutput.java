package com.zerefstbl.store.application.outputs;

import java.math.BigDecimal;

import com.zerefstbl.store.domain.model.Product;

public record UpdateProductOutput(long id, String name, String description, BigDecimal price) {
    
    public static UpdateProductOutput from(final Product product) {
        return new UpdateProductOutput(product.getId(), product.getName(), product.getDescription(), product.getPrice());
    }

}
