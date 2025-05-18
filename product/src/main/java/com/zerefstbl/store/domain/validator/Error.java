package main.java.com.zerefstbl.store.domain.validator;

public record Error(
    String field,
    String message
) {

    private Error(String field, String message) {
        this.field = field;
        this.message = message;
    }

    public static Error newError(String field, String message) {
        return new Error(field, message);
    }

}
