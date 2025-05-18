package com.zerefstbl.store.application.outputs;

import com.zerefstbl.store.domain.model.Product;

public record CreateProductOutput(long id) {
    
    public static CreateProductOutput from(final Product product) {
        return new CreateProductOutput(product.getId());
    }

}
