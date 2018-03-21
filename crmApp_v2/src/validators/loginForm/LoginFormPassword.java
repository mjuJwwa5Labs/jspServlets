package validators.loginForm;

import validators.Errors;
import validators.Validator;

public class LoginFormPassword implements Validator {

    @Override
    public void validate(Object object, Errors errors) {
        String password = (String) object;

        if (password==null || password.equals("")) {
            errors.addError("password", "Hasło nie może być puste");
        }
    }
}
