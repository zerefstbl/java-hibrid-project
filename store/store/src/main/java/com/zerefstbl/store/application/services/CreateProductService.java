package com.zerefstbl.store.application.services;

import com.zerefstbl.store.application.commands.CreateProductCommand;
import com.zerefstbl.store.application.outputs.CreateProductOutput;
import com.zerefstbl.store.application.ports.in.CreateProductUseCase;

public class CreateProductService implements CreateProductUseCase {

    @Override
    public CreateProductOutput execute(CreateProductCommand createProductCommand) {
        return null;
    }
    
}
