package fr.jousse.simplejavaservlet.validations;

import java.util.ArrayList;
import java.util.List;

public class LoginValidationCommand {

    private final String email;
    private final String password;

    private final List<ValidationError> errors;

    public LoginValidationCommand(String email, String password) {
        this.email = email;
        this.password = password;
        this.errors = new ArrayList<>();
    }

    public void addError(ValidationError error) {
        this.errors.add(error);
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public List<ValidationError> getErrors() {
        return errors;
    }
}
