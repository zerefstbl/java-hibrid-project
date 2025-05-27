package com.zerefstbl.store.infrastructure.config;

import com.zerefstbl.store.application.ports.in.*;
import com.zerefstbl.store.application.ports.out.DeleteProductPort;
import com.zerefstbl.store.application.ports.out.LoadProductPort;
import com.zerefstbl.store.application.ports.out.SaveProductPort;
import com.zerefstbl.store.application.ports.out.UpdateProductPort;
import com.zerefstbl.store.application.services.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Objects;

@Configuration
public class UseCaseConfig {

    private final SaveProductPort saveProductPort;
    private final LoadProductPort loadProductPort;
    private final UpdateProductPort updateProductPort;
    private final DeleteProductPort deleteProductPort;

    public UseCaseConfig(
            final SaveProductPort saveProductPort,
            final LoadProductPort loadProductPort,
            final UpdateProductPort updateProductPort,
            final DeleteProductPort deleteProductPort
    ) {
        this.saveProductPort = Objects.requireNonNull(saveProductPort);
        this.loadProductPort = Objects.requireNonNull(loadProductPort);
        this.updateProductPort = Objects.requireNonNull(updateProductPort);
        this.deleteProductPort = Objects.requireNonNull(deleteProductPort);
    }

    @Bean
    public CreateProductUseCase  createProductUseCase() {
        return new CreateProductService(saveProductPort, loadProductPort);
    }

    @Bean
    public UpdateProductUseCase updateProductUseCase() {
        return new UpdateProductService(updateProductPort);
    }

    @Bean
    public ListProducstUseCase listProducstUseCase() {
        return new ListProductsService(loadProductPort);
    }

    @Bean
    public DeleteProductUseCase deleteProductService() {
        return new DeleteProductService(deleteProductPort);
    }

    @Bean
    public RetrieveProductUseCase retrieveProductUseCase() {
        return new RetrieveProductService(loadProductPort);
    }

}
