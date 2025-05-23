package com.zerefstbl.store.domain.validator;

public record Error(
    String field,
    String message
) {

    public static Error newError(String field, String message) {
        return new Error(field, message);
    }

}
