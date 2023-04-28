package fr.jousse.simplejavaservlet.validations;

public abstract class LoginValidation {

    protected LoginValidation nextValidation;

    protected LoginValidationCommand command;

    abstract boolean isValid();
    void setNext(LoginValidation validation) {
        this.nextValidation = validation;
    }

    boolean validate() {
        if (isValid()) {
            return nextValidation.validate();
        }
        return false;
    }

}
