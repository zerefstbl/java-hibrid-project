package com.zerefstbl.store.application.services;

import com.zerefstbl.store.application.ports.in.DeleteProductUseCase;

import com.zerefstbl.store.application.ports.out.DeleteProductPort;

public class DeleteProductService implements DeleteProductUseCase {

    private final DeleteProductPort deleteProductPort;

    public DeleteProductService(final DeleteProductPort deleteProductPort) {
        this.deleteProductPort = deleteProductPort;
    }

    @Override
    public void execute(final long id) {
        deleteProductPort.deleteById(id);
    }
    
}
