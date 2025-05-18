package com.zerefstbl.store.application.outputs;

import java.math.BigDecimal;

import com.zerefstbl.store.domain.model.Product;

public record RetrieveProductOutput(long id, String name, String description, BigDecimal price) {
    
    public static RetrieveProductOutput from(final Product product) {
        return new RetrieveProductOutput(product.getId(), product.getName(), product.getDescription(), product.getPrice());
    }
    
}
