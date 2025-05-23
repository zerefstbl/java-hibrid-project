package com.zerefstbl.store.domain.validator;

import java.util.function.Predicate;

public interface FluentValidator<T> {
    
    FluentValidator<T> validate(Predicate<T> rule, String message);
    void execute();

}
