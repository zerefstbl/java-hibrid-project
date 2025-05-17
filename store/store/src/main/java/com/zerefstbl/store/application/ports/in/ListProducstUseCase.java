package com.zerefstbl.store.application.ports.in;

import java.util.List;

import com.zerefstbl.store.application.outputs.ListProductOutput;

public interface ListProducstUseCase {

    List<ListProductOutput> execute();
    
}
