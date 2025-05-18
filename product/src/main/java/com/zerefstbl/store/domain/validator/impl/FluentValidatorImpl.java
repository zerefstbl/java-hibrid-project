package main.java.com.zerefstbl.store.domain.validator;

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
            throw new ValidationException(errors);
        }
    }

    @Override
    public FluentValidator<T> validate(Predicate<T> rule, String message) {
        if (errors.isEmpty) {
            this.errors = new ArrayList<>();
        }

        if (rule.test(target)) {
            errors.add(message);
        }

        return this;
    }
    
    

}
