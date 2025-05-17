package com.zerefstbl.store.application.ports.in;

import com.zerefstbl.store.application.commands.CreateProductCommand;
import com.zerefstbl.store.application.outputs.CreateProductOutput;

public interface CreateProductUseCase {

    CreateProductOutput execute(CreateProductCommand createProductCommand);
    
}
