package fr.jousse.simplejavaservlet.validations;

@LoginValidationAnnotation(priority = 3)
public final class UserPasswordLoginValidation extends LoginValidation {
    @Override
    boolean isValid() {
        if (this.command.getEmail().equals("valide@domain.com") && this.command.getPassword().equals("valide")) {
            return true;
        }
        this.command.addError(new ValidationError("Bad password", "password"));
        return false;
    }
}
