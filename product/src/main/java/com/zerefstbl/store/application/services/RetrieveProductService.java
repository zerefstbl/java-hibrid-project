package com.zerefstbl.store.application.services;

import com.zerefstbl.store.application.outputs.RetrieveProductOutput;
import com.zerefstbl.store.application.ports.in.RetrieveProductUseCase;
import com.zerefstbl.store.application.ports.out.LoadProductPort;

public class RetrieveProductService implements RetrieveProductUseCase {

    private final LoadProductPort loadProductPort;

    public RetrieveProductService(final LoadProductPort loadProductPort) {
        this.loadProductPort = loadProductPort;
    }

    @Override
    public RetrieveProductOutput execute(long id) {
        return RetrieveProductOutput.from(loadProductPort.findById(id));
    }

}
