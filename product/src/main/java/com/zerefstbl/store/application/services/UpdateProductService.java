package com.zerefstbl.store.application.services;

import com.zerefstbl.store.application.commands.UpdateProductCommand;
import com.zerefstbl.store.application.outputs.UpdateProductOutput;
import com.zerefstbl.store.application.ports.in.UpdateProductUseCase;
import com.zerefstbl.store.domain.model.Product;

import main.java.com.zerefstbl.store.application.ports.out.UpdateProductPort;

public class UpdateProductService implements UpdateProductUseCase {

    private final UpdateProductPort updateProductPort;

    public UpdateProductService(final UpdateProductPort updateProductPort) {
        this.updateProductPort = updateProductPort;
    }

    @Override
    public UpdateProductOutput execute(UpdateProductCommand updateProductCommand) {
        final Product product = Product.
        return null;
    }

}
