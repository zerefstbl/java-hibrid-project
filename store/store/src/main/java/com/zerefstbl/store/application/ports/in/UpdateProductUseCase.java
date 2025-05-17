package com.zerefstbl.store.application.ports.in;

import com.zerefstbl.store.application.commands.UpdateProductCommand;
import com.zerefstbl.store.application.outputs.UpdateProductOutput;

public interface UpdateProductUseCase {

    UpdateProductOutput execute(UpdateProductCommand updateProductCommand);
    
}
