package com.zerefstbl.store.application.ports.out;

import java.util.List;

import com.zerefstbl.store.domain.model.Product;

public interface LoadProductPort {

    List<Product> findAll();

    Product findById(final long id);

    boolean existsByName(final String name);

}
