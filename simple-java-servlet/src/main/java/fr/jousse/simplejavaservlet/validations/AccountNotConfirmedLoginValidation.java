package fr.jousse.simplejavaservlet.validations;

@LoginValidationAnnotation(priority = 2)
public final class AccountNotConfirmedLoginValidation extends LoginValidation {
  @Override
  boolean isValid() {
    if (this.command.getEmail().equals("non-confirmed@domain.com")) {
      this.command.addError(new ValidationError("Email not confirmed", "email"));
      return false;
    }
    return true;
  }
}
