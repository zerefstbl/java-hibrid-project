package com.zerefstbl.store.domain.validator.impl;

import com.zerefstbl.store.domain.exceptions.ValidationException;
import com.zerefstbl.store.domain.validator.FluentValidator;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class FluentValidatorImpl<T> implements FluentValidator<T> {

    T target;
    List<Error> errors;

    public FluentValidatorImpl(T target) {
        this.target = target;
    }

    @Override
    public void execute() {
        if (!errors.isEmpty()) {
            throw ValidationException.with(errors);
        }
    }

    @Override
    public FluentValidator<T> validate(Predicate<T> rule, String message) {
        if (errors.isEmpty()) {
            this.errors = new ArrayList<>();
        }

        if (rule.test(target)) {
            errors.add(new Error(message));
        }

        return this;
    }
    
    

}
