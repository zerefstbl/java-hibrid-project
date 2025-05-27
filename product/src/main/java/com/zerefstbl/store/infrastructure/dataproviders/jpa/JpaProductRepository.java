package com.zerefstbl.store.infrastructure.dataproviders.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaProductRepository extends JpaRepository<JpaProductEntity, Long> {

    boolean existsByName(String name);

}
