package fr.jousse.simplejavaservlet.validations;

@LoginValidationAnnotation(priority = 1)
public final class InDatabaseLoginValidation extends LoginValidation {

    @Override
    boolean isValid() {
        
        if (!this.command.getEmail().equals("valide@domain.com")) {
            this.command.addError(new ValidationError("User unknown", "email"));
            return false;
        }
        return true;
    }
}
