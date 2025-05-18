package main.java.com.zerefstbl.store.application.ports.out;

import com.zerefstbl.store.domain.model.Product;

public interface SaveProductPort {
    
    Product save(final Product product);

}
