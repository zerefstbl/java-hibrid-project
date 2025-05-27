package com.zerefstbl.store.infrastructure.dataproviders.jpa;

import com.zerefstbl.store.application.ports.out.DeleteProductPort;
import com.zerefstbl.store.application.ports.out.LoadProductPort;
import com.zerefstbl.store.application.ports.out.SaveProductPort;
import com.zerefstbl.store.application.ports.out.UpdateProductPort;
import com.zerefstbl.store.domain.model.Product;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductPersistenceAdapter implements
        LoadProductPort, DeleteProductPort, SaveProductPort, UpdateProductPort {

    private final JpaProductRepository productRepository;

    public ProductPersistenceAdapter(final JpaProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public void deleteById(long id) {
        productRepository.deleteById(id);
    }

    @Override
    public List<Product> findAll() {
        return productRepository
                .findAll()
                .stream()
                .map(JpaProductEntity::toDomainProduct)
                .toList();
    }

    @Override
    public Product findById(long id) {
        return productRepository
                .findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid product id"))
                .toDomainProduct();
    }

    @Override
    public boolean existsByName(String name) {
        return productRepository.existsByName(name);
    }

    @Override
    public Product save(Product product) {
        return productRepository.save(JpaProductEntity.from(product)).toDomainProduct();
    }

    @Override
    public Product update(Product product) {
        return productRepository.save(JpaProductEntity.from(product)).toDomainProduct();
    }
}
