package main.java.com.zerefstbl.store.domain.exceptions;

import java.util.List;

public class ValidationException extends RuntimeException {

    protected final List<Error> errors;

    protected ValidationException(List<Error> errors) {
        this.errors = errors;
    }

    public static ValidationException with(List<Error> errors) {
        return new ValidationException(errors);
    }

    public List<Error> getErrors() {
        return errors;
    }

}
