package com.zerefstbl.store.application.services;

import java.util.List;

import com.zerefstbl.store.application.outputs.ListProductOutput;
import com.zerefstbl.store.application.ports.in.ListProducstUseCase;
import com.zerefstbl.store.application.ports.out.LoadProductPort;

public class ListProductsService implements ListProducstUseCase {

    private final LoadProductPort loadProductPort;

    public ListProductsService(final LoadProductPort loadProductPort) {
        this.loadProductPort = loadProductPort;
    }

    @Override
    public List<ListProductOutput> execute() {
        return loadProductPort
                .findAll()
                .stream()
                .map(ListProductOutput::from)
                .toList();
    }

}
