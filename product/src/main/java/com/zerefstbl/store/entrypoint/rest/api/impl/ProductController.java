package com.zerefstbl.store.entrypoint.rest.api.impl;

import com.zerefstbl.store.application.ports.in.CreateProductUseCase;
import com.zerefstbl.store.entrypoint.rest.api.ProductAPI;
import com.zerefstbl.store.entrypoint.rest.dto.CreateProductRequest;
import com.zerefstbl.store.entrypoint.rest.dto.ProductResponse;
import com.zerefstbl.store.entrypoint.rest.mapper.ProductRestMapper;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController implements ProductAPI {

    private final CreateProductUseCase createProductUseCase;

    public ProductController(final CreateProductUseCase createProductUseCase) {
        this.createProductUseCase = createProductUseCase;
    }

    @Override
    public ResponseEntity<ProductResponse> createProduct(CreateProductRequest createProductRequest, HttpServletRequest httpServletRequest) {
        final var aCommand = ProductRestMapper.toCommand(createProductRequest);
        final var output = createProductUseCase.execute(aCommand);
        return ResponseEntity.ok(ProductRestMapper.toResponse(output));
    }
}
