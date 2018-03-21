package validators.loginForm;

import validators.Errors;
import validators.Validator;

public class LoginFromLogin implements Validator {

    @Override
    public void validate(Object object, Errors errors) {
        String login = (String) object;

        if (login==null || login.equals("")) {
            errors.addError("login", "Wypełnij pole login");
        }

        if (login!=null && login!="" && !login.matches("[a-zA-Z]+")) {
            errors.addError("login","Login może zawierac tylko litery");
        }
    }
}
