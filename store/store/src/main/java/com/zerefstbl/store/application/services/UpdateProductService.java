package com.zerefstbl.store.application.services;

import com.zerefstbl.store.application.commands.UpdateProductCommand;
import com.zerefstbl.store.application.outputs.UpdateProductOutput;
import com.zerefstbl.store.application.ports.in.UpdateProductUseCase;

public class UpdateProductService implements UpdateProductUseCase {

    @Override
    public UpdateProductOutput execute(UpdateProductCommand updateProductCommand) {
        return null;
    }
    
}
