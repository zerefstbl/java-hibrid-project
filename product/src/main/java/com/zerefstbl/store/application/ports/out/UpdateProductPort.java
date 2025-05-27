package com.zerefstbl.store.application.ports.out;

import com.zerefstbl.store.domain.model.Product;

public interface UpdateProductPort {
    
    Product update(final Product product);

}
