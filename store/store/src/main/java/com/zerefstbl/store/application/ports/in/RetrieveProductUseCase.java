package com.zerefstbl.store.application.ports.in;

import com.zerefstbl.store.application.outputs.RetrieveProductOutput;

public interface RetrieveProductUseCase {
    
    RetrieveProductOutput execute(long id);

}
