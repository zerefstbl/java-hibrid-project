package com.zerefstbl.store.application.services;

import com.zerefstbl.store.application.commands.CreateProductCommand;
import com.zerefstbl.store.application.outputs.CreateProductOutput;
import com.zerefstbl.store.application.ports.in.CreateProductUseCase;
import com.zerefstbl.store.application.ports.out.LoadProductPort;
import com.zerefstbl.store.application.ports.out.SaveProductPort;
import com.zerefstbl.store.domain.exceptions.ValidationException;
import com.zerefstbl.store.domain.model.Product;

import com.zerefstbl.store.domain.validator.impl.FluentValidatorImpl;

public class CreateProductService implements CreateProductUseCase {

    private final SaveProductPort saveProductPort;
    private final LoadProductPort loadProductPort;

    public CreateProductService(final SaveProductPort saveProductPort, final LoadProductPort loadProductPort) {
        this.saveProductPort = saveProductPort;
        this.loadProductPort = loadProductPort;
    }

    @Override
    public CreateProductOutput execute(CreateProductCommand createProductCommand) throws ValidationException {
        Product product = Product.newProduct(createProductCommand.name(), createProductCommand.description(), createProductCommand.price());
        validate(product);
        return CreateProductOutput.from(saveProductPort.save(product));
    }

    public void validate(Product product) {
        new FluentValidatorImpl<>(product)
                .validate(p -> loadProductPort.existsByName(p.getName()), "Product with this name already exist.")
                .execute();
    }

}
