package com.zerefstbl.store.domain.model;

import java.math.BigDecimal;

import main.java.com.zerefstbl.store.domain.validator.FluentValidatorImpl;

public class Product {

    private final long id;
    private final String name;
    private final BigDecimal price;
    private final String description;

    private Product(long id, String name, BigDecimal price, String description) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
    }

    public static Product newProduct(final String name, final String description, final BigDecimal price) {
        isValidPrice(price);
        return new Product(Long.MIN_VALUE, name, price, description);
    }

    public static Product with(final long id, final String name, final String description, final BigDecimal price) {
        return new Product(id, name, price, description);
    }

    private static void isValidPrice(final BigDecimal price) {
        if (price.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalStateException("Invalid product price. Price must be have price more than 0");
        }
    }

    private void validate() {
        new FluentValidatorImpl<>(this)
                .validate(p -> p.price.compareTo(BigDecimal.ZERO) < 0, "Invalid product price. Product must be have price more than 0")
                .validate(p -> p.name != null || p.name.isEmpty, "Name should not be null os empty")
                .execute();
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

}
