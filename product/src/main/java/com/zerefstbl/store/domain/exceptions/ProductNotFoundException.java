package com.zerefstbl.store.domain.exceptions;

public class ProductNotFoundException extends RuntimeException {

    public ProductNotFoundException(final Long id) {
        super("Product not found: " + id);
    }

}
