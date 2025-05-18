package com.zerefstbl.store.application.outputs;

import java.math.BigDecimal;

import com.zerefstbl.store.domain.model.Product;

public record ListProductOutput(long id, String name, String description, BigDecimal price) {
    
    public static ListProductOutput from(final Product product) {
        return new ListProductOutput(product.getId(), product.getName(), product.getDescription(), product.getPrice());
    }

}
