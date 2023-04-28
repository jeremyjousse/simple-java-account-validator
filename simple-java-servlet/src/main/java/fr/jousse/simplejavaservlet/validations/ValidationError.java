package fr.jousse.simplejavaservlet.validations;

public class ValidationError {
    private final String message;
    private final String field;

    public ValidationError(String message, String field) {
        this.message = message;
        this.field = field;
    }

    public String getMessage() {
        return message;
    }

    public String getField() {
        return field;
    }
}
