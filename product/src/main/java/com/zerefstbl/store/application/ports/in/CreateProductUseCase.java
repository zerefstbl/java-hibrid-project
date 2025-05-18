package com.zerefstbl.store.application.ports.in;

import com.zerefstbl.store.application.commands.CreateProductCommand;
import com.zerefstbl.store.application.outputs.CreateProductOutput;

import main.java.com.zerefstbl.store.domain.exceptions.ValidationException;

public interface CreateProductUseCase {

    CreateProductOutput execute(CreateProductCommand createProductCommand) throws ValidationException;
    
}
