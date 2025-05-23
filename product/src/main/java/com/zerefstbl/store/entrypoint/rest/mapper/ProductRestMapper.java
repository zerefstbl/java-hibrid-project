package com.zerefstbl.store.entrypoint.rest.mapper;

import com.zerefstbl.store.application.commands.CreateProductCommand;
import com.zerefstbl.store.application.outputs.CreateProductOutput;
import com.zerefstbl.store.entrypoint.rest.dto.CreateProductRequest;
import com.zerefstbl.store.entrypoint.rest.dto.ProductResponse;

public class ProductRestMapper {

    public static CreateProductCommand toCommand(final CreateProductRequest createProductRequest) {
        return CreateProductCommand.with(
                createProductRequest.name(),
                createProductRequest.description(),
                createProductRequest.price()
        );
    }

    public static ProductResponse toResponse(final CreateProductOutput createProductOutput) {
        return new ProductResponse(
                createProductOutput.id(),
                createProductOutput.name(),
                createProductOutput.description(),
                createProductOutput.price()
        );
    }


}
